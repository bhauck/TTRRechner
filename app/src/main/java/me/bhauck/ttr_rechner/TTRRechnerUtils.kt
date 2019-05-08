package me.bhauck.ttr_rechner

import java.lang.Math.pow
import java.lang.Math.round

fun calculateTTR(ttr_A: Double, ttr_opponents: Array<Double>, change_const: Int): Int {
    var result = ttr_opponents.size as Double

    var denominator = 1 + pow(10.0, (ttr_opponents[0] - ttr_A) / 150)
    var expected_result = 1 / denominator

    var ttr_new = (ttr_A + round((result - expected_result) * change_const)) as Int

    return ttr_new
}
