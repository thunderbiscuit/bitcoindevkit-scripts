/**
 * bdk-jvm 0.25.0
 *
 * Create a transaction with an OP_RETURN output.
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
        100u
    )
)

object LogProgress : Progress {
    override fun update(progress: Float, message: String?) {
        println("Syncing...")
    }
}

val descriptor = "wpkh([5fa993c4/84'/1'/0'/0]tprv8hwWMmPE4BVNxGdVt3HhEERZhondQvodUY7Ajyseyhudr4WabJqWKWLr4Wi2r26CDaNCQhhxEftEaNzz7dPGhWuKFU4VULesmhEfZYyBXdE/0/*)"
val wallet = Wallet(descriptor, null, Network.TESTNET, memoryDatabaseConfig)
val blockchain = Blockchain(blockchainConfig);
    
wallet.sync(blockchain, LogProgress)
val balance = wallet.getBalance()
check(balance.total > 0uL) { 
     "Wallet balance is 0, please add funds!"
}

val message = "Working with friends is a happy way to live.".toByteArray(charset = Charsets.UTF_8).asUByteArray().toList()
val faucetAddress = "tb1ql7w62elx9ucw4pj5lgw4l028hmuw80sndtntxt"

val (psbt, txDetails) = TxBuilder()
        .addRecipient(Address(faucetAddress).scriptPubkey(), 1000u)
        .feeRate(2.0f)
        .addData(message)
        .finish(wallet)

println("OP_RETURN transaction created: ${wallet.sign(psbt)}")
println("Transaction details: $txDetails")
