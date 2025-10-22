package com.codelabuk.spark.core.metadata

trait MetadataBackend {
    def get(queryHash: String): Option[CacheMetadata]
    def put(metadata: CacheMetadata): Unit
}
