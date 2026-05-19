# [1.6.0](https://github.com/floci-io/testcontainers-floci/compare/v1.5.0...v1.6.0) (2026-05-19)


### Features

* add missing tests for various FlociContainer service configs ([05a194f](https://github.com/floci-io/testcontainers-floci/commit/05a194f994b6265768f007467805e4c76a96f4ff))
* added support for Pricing Service ([6669e20](https://github.com/floci-io/testcontainers-floci/commit/6669e20337f14f334996428f64271cad5886d4ce))



# [1.5.0](https://github.com/floci-io/testcontainers-floci/compare/v1.4.0...v1.5.0) (2026-05-12)


### Bug Fixes

* Athena tests are working with most recent Floci release and can be activated ([1d8e5a6](https://github.com/floci-io/testcontainers-floci/commit/1d8e5a6ff53a9963376bcd93bc85c33e92c15dda))
* deactivated failing OpenSearch tests ([d2256a8](https://github.com/floci-io/testcontainers-floci/commit/d2256a81cb9b4997500d71f675c2b484b2075072))
* OpenSearch is not exposing ports as proxy. Adopted configuration accordingly. ([4fcc404](https://github.com/floci-io/testcontainers-floci/commit/4fcc404cfc2fc60f01444eecd1dc1a2d93f8b0b1))


### Features

* Add support for config of Backup, Transfer Family, and Route 53 ([feec359](https://github.com/floci-io/testcontainers-floci/commit/feec3592688703cd57337dea0e26fe7e49d6c364))
* Add support for EC2 auto-scaling config ([ce15b8c](https://github.com/floci-io/testcontainers-floci/commit/ce15b8c61c1f660269028175de4b8a98550c8540))
* Add support for Lambda awsConfigPath property ([3414411](https://github.com/floci-io/testcontainers-floci/commit/34144116f24de1159bd2fc6c58d08808e451397b))
* Add support for Textract ([9ab3d68](https://github.com/floci-io/testcontainers-floci/commit/9ab3d6878fd2f835fe6f5094038330b02374d474))
* added support for accessing Floci via TLS ([d82ed9d](https://github.com/floci-io/testcontainers-floci/commit/d82ed9d835450d46b31297b09f207d57a74dbccc))
* added support for EC2 starting up real containers ([e3f813c](https://github.com/floci-io/testcontainers-floci/commit/e3f813cc764c5577013e416160c52ba7ac6e5e47))
* added support for ELBv2 with forwarding to real load balancer ([b6385c0](https://github.com/floci-io/testcontainers-floci/commit/b6385c05e3dd18589a8912571166ec674b7a5fe9))
* use named-volumes as default for data persistence ([4e8169b](https://github.com/floci-io/testcontainers-floci/commit/4e8169b6f60cb7e64f2f87a607905e76ccde5a01))



# [1.4.0](https://github.com/floci-io/testcontainers-floci/compare/v1.3.0...v1.4.0) (2026-04-30)


### Bug Fixes

* running Floci as user root is not required any longer ([8f7251b](https://github.com/floci-io/testcontainers-floci/commit/8f7251b24a0233222f7d7ac0cc7114c450d75cba))


### Features

* **athena:** added support for floci-duck mode of AWS Athena ([de5bac6](https://github.com/floci-io/testcontainers-floci/commit/de5bac6e3fb007168857d3751eb8fad70b6b0b26))
* **codebuild:** added support for dockerNetwork config for CodeBuild ([fb9f600](https://github.com/floci-io/testcontainers-floci/commit/fb9f600f587ebe3fb191d979aa98ecc17922a2f8))
* **lambda:** added support for Lambda hot-reload configuration ([1ea6b79](https://github.com/floci-io/testcontainers-floci/commit/1ea6b79828e9256f72661cb5ea72b3251bd49206))
* **services:** added missing configuration options and services from Floci v1.5.9 ([286d782](https://github.com/floci-io/testcontainers-floci/commit/286d7827f6df49e85d49a9693cca4d37283fd623))



# [1.3.0](https://github.com/floci-io/testcontainers-floci/compare/v1.2.0...v1.3.0) (2026-04-24)


### Features

* added missing configuration options and services from Floci v1.5.7 ([b80ca75](https://github.com/floci-io/testcontainers-floci/commit/b80ca756868e7f666c4f966da953019e9c4fb791))



# [1.2.0](https://github.com/floci-io/testcontainers-floci/compare/v1.1.0...v1.2.0) (2026-04-23)


### Features

* added configuration support for default account id and default availability zone ([8278e21](https://github.com/floci-io/testcontainers-floci/commit/8278e217f374cfd77ef5b36af69a3361b70aa207))
* added support for configuring all services supported by Floci that don't startup child containers ([905813e](https://github.com/floci-io/testcontainers-floci/commit/905813e64fd93abb4fa215a61b2b3d85bccafa42))
* added support for ElastiCache, OpenSearch, ECS and ECR. ([b55bc6e](https://github.com/floci-io/testcontainers-floci/commit/b55bc6eafc18ca37889a2bad9c72ff5a94862442))
* floci docker image moved ([01f0fa8](https://github.com/floci-io/testcontainers-floci/commit/01f0fa82ca4535c7204e93e971b8b4421f715c2d))



