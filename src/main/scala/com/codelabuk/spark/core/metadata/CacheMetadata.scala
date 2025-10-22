package com.codelabuk.spark.core.metadata

case class CacheMetadata(queryHash: String,
                         cachePath: String,
                         createdAt: Long,
                         ttlSeconds: Long,
                         schema: String,
                         tags: Seq[String] = Seq()
                        )
