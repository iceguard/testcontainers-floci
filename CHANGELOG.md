# [2.6.0](https://github.com/floci-io/testcontainers-floci/compare/v2.5.0...v2.6.0) (2026-05-12)


### Bug Fixes

* Athena tests are working with most recent Floci release and can be activated ([8ff8571](https://github.com/floci-io/testcontainers-floci/commit/8ff8571625a6dde512144b75edc66724493d427e))
* deactivated failing OpenSearch tests ([900b765](https://github.com/floci-io/testcontainers-floci/commit/900b765086469fd31f34c2231123ffb0ba239119))
* OpenSearch is not exposing ports as proxy. Adopted configuration accordingly. ([3c54b96](https://github.com/floci-io/testcontainers-floci/commit/3c54b96a65ef0f6958a187c77495107f12d43c5c))


### Features

* Add support for config of Backup, Transfer Family, and Route 53 ([c8c6eea](https://github.com/floci-io/testcontainers-floci/commit/c8c6eea68fc4ac5dc23e7decef7466b28bd43a07))
* Add support for EC2 auto-scaling config ([9cb7c72](https://github.com/floci-io/testcontainers-floci/commit/9cb7c72c345d27eea3aab925fb09858c3bee3186))
* Add support for Lambda awsConfigPath property ([0495c9e](https://github.com/floci-io/testcontainers-floci/commit/0495c9e456729c17dfd92ead2fb30c05f5730fef))
* Add support for Textract ([f0a095c](https://github.com/floci-io/testcontainers-floci/commit/f0a095c1fcbd52e255d02cf557909f282ccacd2b))
* added support for accessing Floci via TLS ([693c8ca](https://github.com/floci-io/testcontainers-floci/commit/693c8ca603c26737e1e85ca55bece5287718228f))
* added support for EC2 starting up real containers ([4298a60](https://github.com/floci-io/testcontainers-floci/commit/4298a6005cc4441dae832edba4d8dd7a4c11ee56))
* added support for ELBv2 with forwarding to real load balancer ([8a390a0](https://github.com/floci-io/testcontainers-floci/commit/8a390a039ebb52bb62ab613885401e12228d23d9))
* use named-volumes as default for data persistence ([008b4f1](https://github.com/floci-io/testcontainers-floci/commit/008b4f10c614b41697c87dc58ef2661b78137e50))



# [2.5.0](https://github.com/floci-io/testcontainers-floci/compare/v2.4.0...v2.5.0) (2026-04-30)


### Bug Fixes

* running Floci as user root is not required any longer ([680fbe6](https://github.com/floci-io/testcontainers-floci/commit/680fbe6a3dfb257b1478a21778b73b8422ba0ae0))


### Features

* **athena:** added support for floci-duck mode of AWS Athena ([9dccb06](https://github.com/floci-io/testcontainers-floci/commit/9dccb06d141a2ed212e74017245c20e716c81429))
* **codebuild:** added support for dockerNetwork config for CodeBuild ([e0c7aa6](https://github.com/floci-io/testcontainers-floci/commit/e0c7aa63213631b04f6384e83a433cf0ec96fa72))
* **lambda:** added support for Lambda hot-reload configuration ([98f9763](https://github.com/floci-io/testcontainers-floci/commit/98f976327478147690ce0e0209e511c2680691c2))
* **services:** added missing configuration options and services from Floci v1.5.9 ([8dc2c2a](https://github.com/floci-io/testcontainers-floci/commit/8dc2c2ad332a7618724748d6e65132e724496493))



# [2.4.0](https://github.com/floci-io/testcontainers-floci/compare/v2.3.0...v2.4.0) (2026-04-24)


### Features

* added missing configuration options and services from Floci v1.5.7 ([aebc8e9](https://github.com/floci-io/testcontainers-floci/commit/aebc8e9f87506b7c0b01571eb05455534928722a))



# [2.3.0](https://github.com/floci-io/testcontainers-floci/compare/v2.2.0...v2.3.0) (2026-04-23)


### Features

* added support for ElastiCache, OpenSearch, ECS and ECR. ([0f5c31a](https://github.com/floci-io/testcontainers-floci/commit/0f5c31ad6760896ef0a382c3567be62465b13123))



# [2.2.0](https://github.com/floci-io/testcontainers-floci/compare/v2.1.0...v2.2.0) (2026-04-23)


### Features

* added configuration support for default account id and default availability zone ([4739338](https://github.com/floci-io/testcontainers-floci/commit/473933817ce66e102ba9ee26cc040484d4854357))
* added support for configuring all services supported by Floci that don't startup child containers ([4b4c41f](https://github.com/floci-io/testcontainers-floci/commit/4b4c41f95da3081d8e245cbfe3a28a34c4f2de4a))
* floci docker image moved ([0203051](https://github.com/floci-io/testcontainers-floci/commit/0203051708671897bf4b010041967efa5a074d2d))



