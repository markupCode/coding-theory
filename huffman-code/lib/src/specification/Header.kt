package huffman.code.lib.specification

import huffman.code.lib.BinaryStringEncoder

/**
 * @property statsTable should contain only 0 and 1
 * */
class Header {
    var symbolLengthInBits: Byte = 8
    var frequencyLengthInBits: Byte = 16
    var symbolCount: Short = 0
    var emptyBitCount: Byte = 0
    var statsTable: String = ""

    companion object {
        fun create(): HeaderBuilder {
            return HeaderBuilder(Header())
        }
    }

    val fullSizeInBits
        get() = 8 + 8 + 16 + 8 + statsTable.length

    val fullSizeInBytes
        get() = fullSizeInBits / 8

    val bytesPerSymbol
        get() = (symbolLengthInBits + frequencyLengthInBits) / 8

    val statsTableSizeInBytes
        get() = symbolCount * bytesPerSymbol

    fun toBinaryString(encoder: BinaryStringEncoder): String {
        return StringBuilder()
                .append(encoder.toBinaryString(symbolLengthInBits, 8))
                .append(encoder.toBinaryString(frequencyLengthInBits, 8))
                .append(encoder.toBinaryString(symbolCount, 16))
                .append(encoder.toBinaryString(emptyBitCount, 8))
                .append(statsTable)
                .toString()
    }
}