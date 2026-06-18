# [2.10.0](https://github.com/floci-io/testcontainers-floci/compare/v2.9.0...v2.10.0) (2026-06-18)


### Features

* **cloudmap:** added support for AWS CloudMap ([78ffc57](https://github.com/floci-io/testcontainers-floci/commit/78ffc57a48b0ed815e32b68b01d17403bb28f2bd))
* **cloudtrail:** added support for AWS CloudTrail ([e65b505](https://github.com/floci-io/testcontainers-floci/commit/e65b505adf2ad47d63540541d12e68053c532b97))



# [2.9.0](https://github.com/floci-io/testcontainers-floci/compare/v2.8.0...v2.9.0) (2026-06-04)


### Bug Fixes

* ensure Optional<> is used only for return values ([35c49c2](https://github.com/floci-io/testcontainers-floci/commit/35c49c277b2f4b6ac93e6046d9cde42fb0c512c9))
* wait for startup scripts to complete ([7881a9c](https://github.com/floci-io/testcontainers-floci/commit/7881a9c2ac37121c893b50f6e84eece60a6a38c0))


### Features

* **cloud-formation:** added support for configuration of deletedStackRetentionSeconds at Cloud Formation service ([0678af6](https://github.com/floci-io/testcontainers-floci/commit/0678af60f644c2d43592a2f440cd5d1f16f824cc))
* **eks:** added support for endpointMode and IAM auth webhook (de-)activation ([be37d66](https://github.com/floci-io/testcontainers-floci/commit/be37d6652db5e5808c3adf6b6a1550ab72db4df9))
* **opensearch:** make defaultImage property optional and use Floci's default instead ([3df2df6](https://github.com/floci-io/testcontainers-floci/commit/3df2df64fdd550275a11613a47e5aab2a8c79a21))
* **services:** added support for AWS AppSync ([da5f7de](https://github.com/floci-io/testcontainers-floci/commit/da5f7de51379310ba1634421d583eaba93984a20))
* **seurity:** added support for Browser CORS security config ([ecb2c4e](https://github.com/floci-io/testcontainers-floci/commit/ecb2c4edbcd7ebb2f406f0f4fd17be49e853e603))



# [2.8.0](https://github.com/floci-io/testcontainers-floci/compare/v2.7.0...v2.8.0) (2026-05-22)


### Features

* add config support for all services available in Floci 1.5.18 ([5205b0c](https://github.com/floci-io/testcontainers-floci/commit/5205b0cf365d8c98969a27dbe2549e0532c83bc7))
* add support for default Memcached image in ElastiCache configuration ([10aedfc](https://github.com/floci-io/testcontainers-floci/commit/10aedfc14f2aa7492cb9ffc712a1282b6e328a4c))
* moved config from AthenaConfig to a dedicated DuckDB config ([358c696](https://github.com/floci-io/testcontainers-floci/commit/358c696ce71c98cfbb093e12ee1fe4798b2f81be))



# [2.7.0](https://github.com/floci-io/testcontainers-floci/compare/v2.6.0...v2.7.0) (2026-05-15)


### Features

* add missing tests for various FlociContainer service configs ([28d4138](https://github.com/floci-io/testcontainers-floci/commit/28d413878fc06bf056362b344210423bb33f527b))
* added support for Pricing Service ([368d59f](https://github.com/floci-io/testcontainers-floci/commit/368d59f69dc90b482856c6776638845445da38e4))



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



