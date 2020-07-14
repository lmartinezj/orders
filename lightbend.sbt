resolvers in ThisBuild += "lightbend-commercial-mvn" at
  "https://repo.lightbend.com/pass/M6vBWKkzAgrod_m70PgKYNnf7ZX8bKpf69KduDjRA43yEQFP/commercial-releases"
resolvers in ThisBuild += Resolver.url("lightbend-commercial-ivy",
  url("https://repo.lightbend.com/pass/M6vBWKkzAgrod_m70PgKYNnf7ZX8bKpf69KduDjRA43yEQFP/commercial-releases"))(Resolver.ivyStylePatterns)