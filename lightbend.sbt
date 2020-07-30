resolvers in ThisBuild += "lightbend-commercial-mvn" at
  "https://github.com/lmartinezj/repo.lightbend.com/tree/master/https/repo.lightbend.com/pass/M6vBWKkzAgrod_m70PgKYNnf7ZX8bKpf69KduDjRA43yEQFP/commercial-releases"
resolvers in ThisBuild += Resolver.url("lightbend-commercial-ivy",
  url("https://github.com/lmartinezj/repo.lightbend.com/tree/master/https/repo.lightbend.com/pass/M6vBWKkzAgrod_m70PgKYNnf7ZX8bKpf69KduDjRA43yEQFP/commercial-releases"))(Resolver.ivyStylePatterns)