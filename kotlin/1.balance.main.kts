/**
 * bdk-jvm 0.27.1
 *
 * Query an Electrum server for the total balance of a wallet using a descriptor.
 */

@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.27.1")

import org.bitcoindevkit.*

val descriptor = Descriptor("wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)", Network.TESTNET)
val electrumUrl = "ssl://electrum.blockstream.info:60002"
val blockchainConfig = BlockchainConfig.Electrum(ElectrumConfig(electrumUrl, null, 5u, null, 100u, true))
val blockchain = Blockchain(blockchainConfig)
val databaseConfig = DatabaseConfig.Memory

val wallet = Wallet(descriptor, null, Network.TESTNET, databaseConfig)

wallet.sync(
    blockchain = blockchain, 
    progress = null
)

val balance = wallet.getBalance().total
println("The wallet balance is $balance")

// For blockchains that provide a progress update (Bitcoin daemon RPC), you can provide one a callback:
// object LogProgress : Progress {
//     override fun update(progress: Float, message: String?) {
//         println("Syncing... $progress")
//     }
// }

// wallet.sync(
//     blockchain = blockchain,
//     progress = LogProgress
// )
