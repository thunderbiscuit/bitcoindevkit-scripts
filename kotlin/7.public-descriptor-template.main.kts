/**
 * bdk-jvm 0.26.0
 *
 * Create a public descriptor using descriptor templates.
 */

@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.26.0")

import org.bitcoindevkit.*

val descriptorPublicKey: DescriptorPublicKey = DescriptorPublicKey.fromString("tpubDCYVtmaSaDzTxcgvoP5AHZNbZKZzrvoNH9KARep88vESc6MxRqAp4LmePc2eeGX6XUxBcdhAmkthWTDqygPz2wLAyHWisD299Lkdrj5egY6")

val descriptor = Descriptor.newBip84Public(
    publicKey = descriptorPublicKey,
    fingerprint = "9122d9e0",
    keychain = KeychainKind.EXTERNAL,
    network = Network.TESTNET
)

println("The descriptor is ${descriptor.asString()}")
