package com.codelabuk.spark.core.analyzer

import com.codelabuk.spark.core.config.QueryHasherConfig
import org.apache.spark.sql.Dataset

import java.security.MessageDigest

object QueryHasher {

  def hash(df: Dataset[_], config: QueryHasherConfig = QueryHasherConfig()): String = {
    var logicalPlan = df.queryExecution.logical.toString()
    if (config.normalizeWhiteSpace)
      logicalPlan = logicalPlan.replaceAll("\\s+", "").trim
    val messageDigest = MessageDigest.getInstance(config.algorithm)
    val bytes = logicalPlan.getBytes(config.charSet)
    messageDigest.digest(bytes).map("%02x".format(_)).mkString
  }
}
