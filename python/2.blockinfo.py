# bdkpython 0.25.0
# 
# Query an Electrum server for the testnet blockchain height and latest block hash.

import bdkpython as bdk


blockchain_config = bdk.BlockchainConfig.ELECTRUM(
    bdk.ElectrumConfig(
        "ssl://electrum.blockstream.info:60002",
        None,
        5,
        None,
        100
    )
)
blockchain = bdk.Blockchain(blockchain_config)

block_height = blockchain.get_height()
block_hash = blockchain.get_block_hash(block_height)

print(f"Latest block height is {block_height}")
print(f"Latest block hash is {block_hash}")
