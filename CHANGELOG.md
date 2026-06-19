# [1.10.0](https://github.com/floci-io/testcontainers-floci/compare/v1.9.0...v1.10.0) (2026-06-19)


### Features

* **iam:** Added support for IAM property seedDeployerPrincipal ([932676d](https://github.com/floci-io/testcontainers-floci/commit/932676dd6647203b54d91ee72540f227f05b0707))
* **services:** Added support for AWS Batch, DocumentDB, EMR, RDS Data and WAV V2. ([c7f7f04](https://github.com/floci-io/testcontainers-floci/commit/c7f7f04e873f193f8f327479cda25ab3a1c34a10))
* **sqs:** Changed default value of SQS maxMessageSize to 1048576 ([22b89b4](https://github.com/floci-io/testcontainers-floci/commit/22b89b44b5ee92beedba890fd8896cf6ec4f5d04))



# [1.9.0](https://github.com/floci-io/testcontainers-floci/compare/v1.8.0...v1.9.0) (2026-06-18)


### Features

* **cloudmap:** added support for AWS CloudMap ([64f41ac](https://github.com/floci-io/testcontainers-floci/commit/64f41ace0d9d4eec2582bcb94c8f340b997263a0))
* **cloudtrail:** added support for AWS CloudTrail ([7b2f67b](https://github.com/floci-io/testcontainers-floci/commit/7b2f67b2d6d19cd3e1c6163e955ae3e2e040513a))



# [1.8.0](https://github.com/floci-io/testcontainers-floci/compare/v1.7.0...v1.8.0) (2026-06-04)


### Bug Fixes

* ensure Optional<> is used only for return values ([c871a63](https://github.com/floci-io/testcontainers-floci/commit/c871a637812be4b73a48558ec15fe1a878ac7c19))
* wait for startup scripts to complete ([d7a0f56](https://github.com/floci-io/testcontainers-floci/commit/d7a0f56b28f0d0f70692a64dc035df9332692476))


### Features

* **cloud-formation:** added support for configuration of deletedStackRetentionSeconds at Cloud Formation service ([7989a70](https://github.com/floci-io/testcontainers-floci/commit/7989a7092ed9dd32e752d664fae1e76339e3e7bc))
* **eks:** added support for endpointMode and IAM auth webhook (de-)activation ([a1224ff](https://github.com/floci-io/testcontainers-floci/commit/a1224ff2d9c9e3e9d622b2e3d8e7bb2419eca5a7))
* **opensearch:** make defaultImage property optional and use Floci's default instead ([a6646d2](https://github.com/floci-io/testcontainers-floci/commit/a6646d281aaaeea9c690dbe1c6759a876094ff9f))
* **services:** added support for AWS AppSync ([98b16d1](https://github.com/floci-io/testcontainers-floci/commit/98b16d11310dac36d8a732d514b71337c0fc1852))
* **seurity:** added support for Browser CORS security config ([8829676](https://github.com/floci-io/testcontainers-floci/commit/88296769686e2168a1c9941e4292e28abf856bf0))



# [1.7.0](https://github.com/floci-io/testcontainers-floci/compare/v1.6.1...v1.7.0) (2026-05-28)


### Features

* empty commit to increase version ([246eb50](https://github.com/floci-io/testcontainers-floci/commit/246eb503621599d3edb051f8a0e446d2e40a9932))



## [1.6.1](https://github.com/floci-io/testcontainers-floci/compare/v1.5.0...v1.6.1) (2026-05-22)


### Features

* add config support for all services available in Floci 1.5.18 ([151ea66](https://github.com/floci-io/testcontainers-floci/commit/151ea6672730a9393f2229721f243fece2d4d4b6))
* add missing tests for various FlociContainer service configs ([05a194f](https://github.com/floci-io/testcontainers-floci/commit/05a194f994b6265768f007467805e4c76a96f4ff))
* add support for default Memcached image in ElastiCache configuration ([9633e4b](https://github.com/floci-io/testcontainers-floci/commit/9633e4b0ad6a146287db6989204889c0f13d3e32))
* added support for Pricing Service ([6669e20](https://github.com/floci-io/testcontainers-floci/commit/6669e20337f14f334996428f64271cad5886d4ce))
* moved config from AthenaConfig to a dedicated DuckDB config ([2b3af6b](https://github.com/floci-io/testcontainers-floci/commit/2b3af6b53de5ddc0c617e48aeb9e80dcbaf03045))



