/**
 * bdk-jvm 0.11.0
 *
 * Query an Electrum server for the total balance of a wallet.
 */

@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.11.0")

import org.bitcoindevkit.*

val descriptor = "wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)"
val electrumUrl = "ssl://electrum.blockstream.info:60002"
val blockchainConfig = BlockchainConfig.Electrum(ElectrumConfig(electrumUrl, null, 5u, null, 100u))
val blockchain = Blockchain(blockchainConfig)
val databaseConfig = DatabaseConfig.Memory

object LogProgress : Progress {
    override fun update(progress: Float, message: String?) {
        println("Syncing...")
    }
}

val wallet = Wallet(descriptor, null, Network.TESTNET, databaseConfig)

wallet.sync(blockchain, LogProgress)

val balance = wallet.getBalance().total
println("The wallet balance is $balance")
