package com.reactivebbq.orders

import akka.actor.{ActorRef, ActorSystem}
import akka.http.scaladsl.Http
import akka.management.scaladsl.AkkaManagement
import akka.remote.WireFormats.FromConfig
import akka.routing.RoundRobinPool
import org.slf4j.LoggerFactory

object Main extends App {
  val log = LoggerFactory.getLogger(this.getClass)

  val Opt = """-D(\S+)=(\S+)""".r
  args.toList.foreach {
    case Opt(key, value) =>
      log.info(s"Config Override: $key = $value")
      System.setProperty(key, value)
  }

  implicit val system: ActorSystem = ActorSystem("Orders")

  AkkaManagement(system).start()

  val blockingDispatcher = system.dispatchers.lookup("blocking-dispatcher")
  val orderRepository: OrderRepository = new SQLOrderRepository()(blockingDispatcher)

  val orders = system.actorOf(RoundRobinPool(100).props(OrderActor.props(orderRepository)))

  val orderRoutes = new OrderRoutes(orders)(system.dispatcher)

  Http().bindAndHandle(orderRoutes.routes, "localhost")
}
