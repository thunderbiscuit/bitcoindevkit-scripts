/**
 * bdk-jvm 0.25.0
 *
 * Query an Electrum server for the testnet blockchain height and latest block hash.
 */

@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.25.0")

import org.bitcoindevkit.*

val memoryDatabaseConfig = DatabaseConfig.Memory

val blockchainConfig = BlockchainConfig.Electrum(
    ElectrumConfig(
        "ssl://electrum.blockstream.info:60002",
        null,
        5u,
        null,
        200u
    )
)

val blockchain = Blockchain(blockchainConfig)
val blockHeight: UInt = blockchain.getHeight()
val blockHash: String = blockchain.getBlockHash(blockHeight)
println("Latest block height is $blockHeight")
println("Latest block $blockHeight hash is $blockHash")
