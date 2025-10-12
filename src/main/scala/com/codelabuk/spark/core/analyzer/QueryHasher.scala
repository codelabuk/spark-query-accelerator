package com.codelabuk.spark.core.analyzer

import org.apache.spark.sql.Dataset
import java.security.MessageDigest

object QueryHasher {

  def hash(df: Dataset[_]): String = {
    val logicalPlan = df.queryExecution.logical.toString()
    val messageDigest = MessageDigest.getInstance("SHA-256")
    messageDigest.digest(logicalPlan.getBytes("UTF-8")).map("%02x".format(_)).mkString
  }
}
