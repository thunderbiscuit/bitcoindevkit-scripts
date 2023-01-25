# bdkpython 0.25.0
# 
# Query an Electrum server for the testnet blockchain height and latest block hash.

import bdkpython as bdk

blockchain_config = bdk.BlockchainConfig.ELECTRUM(
    bdk.ElectrumConfig(
        url="ssl://electrum.blockstream.info:60002",
        socks5=None,
        retry=5,
        timeout=None,
        stop_gap=100,
        validate_domain=True,
    )
)
blockchain = bdk.Blockchain(blockchain_config)

block_height = blockchain.get_height()
block_hash = blockchain.get_block_hash(block_height)

print(f"Latest block height is {block_height}")
print(f"Latest block hash is {block_hash}")
