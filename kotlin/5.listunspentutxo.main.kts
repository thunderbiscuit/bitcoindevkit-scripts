/**
 * bdk-jvm 0.25.0
 *
 * List the unspent outputs this wallet controls.
 */

@file:DependsOn("org.bitcoindevkit:bdk-jvm:0.25.0")

import org.bitcoindevkit.*

val database = DatabaseConfig.Memory
val blockchainConfig = BlockchainConfig.Electrum(
    ElectrumConfig("ssl://electrum.blockstream.info:60002", null, 5u, null, 100u)
)

object LogProgress : Progress {
    override fun update(progress: Float, message: String?) {
        println("Syncing...")
    }
}

val descriptor = "wpkh(tprv8ZgxMBicQKsPf2qfrEygW6fdYseJDDrVnDv26PH5BHdvSuG6ecCbHqLVof9yZcMoM31z9ur3tTYbSnr1WBqbGX97CbXcmp5H6qeMpyvx35B/84h/1h/0h/0/*)"

val wallet = Wallet(descriptor, null, Network.TESTNET, database)
val blockchain = Blockchain(blockchainConfig)
wallet.sync(blockchain, LogProgress)

val unspentUtxos: List<LocalUtxo> = wallet.listUnspent()
println("There are ${unspentUtxos.size} number of outputs in this wallet")
unspentUtxos.forEach {
    println(it)
}
