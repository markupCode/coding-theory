package volume.analyzer.lib

import java.io.InputStream

interface Analyzable {
    fun Analyze(stream: InputStream, metadata: Metadata): Metadata
}