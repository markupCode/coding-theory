package volume.analyzer.lib

import java.lang.IllegalArgumentException

class Encoding(val bitsPerSymbol: Int) {

    var power: Double = Math.pow(2.0, bitsPerSymbol.toDouble())

    init {
        if (bitsPerSymbol < 1) throw IllegalArgumentException()
    }
}
