package com.codelabuk.spark.core.config

case class QueryHasherConfig(
                              algorithm: String = "SHA-256",
                              charSet: String = "UTF-8",
                              normalizeWhiteSpace: Boolean = true
                            )
