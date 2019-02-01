import java.util.*; 

class Node 
{
	private String blockHash;
	private Block block;
	private ArrayList<Transaction> transactions; 

	public Node(String blockHash, String blockNumber, int size, String timeStamp, String totalDifficulty, String miner, String gasLimit, String gasUsed) 
	{
		this.block = new Block(blockHash, blockNumber, size, timeStamp, totalDifficulty, miner, gasLimit, gasUsed);
		this.blockHash = blockHash;
		transactions = new ArrayList<Transaction>();
	}

	public Node(Block block) 
	{
		this.block = block;
		this.blockHash = block.blockId();
		transactions = new ArrayList<Transaction>();
	}

	public boolean addTransaction(String blockHash, String blockNumber, String from, String to, String contractId, String gasPrice, String txnHash, String index, String value) 
	{
		if(!this.blockHash.equals(blockHash)) {
			System.out.println("Node not found: '"+this.blockHash+"' : '"+blockHash + "'");
			return false;
		}
		Transaction trans = new Transaction(blockHash, blockNumber, from, to, contractId, gasPrice, txnHash, index, value);
		transactions.add(trans);
		return true;
	}

	public boolean addTransaction(Transaction trans)
	{
		if( !this.blockHash.equals(trans.blockId()) ) {
			return false;
		}

		transactions.add(trans);
		return true;


	}

	public void replaceBlock(Block block) {
		this.block = block;
		this.blockHash = block.blockId();
	}

	public String blockId() 
	{
		return blockHash;
	}

	public String blockNumber()
	{
		return block.blockNumber();
	}

	public String gasUsed()
	{
		return block.gasUsed();
	}



	public int compareGasLimit(String gasLimit) 
	{
		return this.block.compareGasLimit(gasLimit);
	}

	public int compareGasLimit(Node node2)
	{
		return this.compareGasLimit(node2.block.getGasLimit());
	}

        public int compareGasUsed(String gasUsed)
        {
                return this.block.compareGasUsed(gasUsed);
        }

        public int compareGasUsed(Node node2)
        {
                return this.compareGasUsed(node2.block.getGasUsed());
        }


	public void sortByGasPrice()
	{
		Collections.sort(transactions, new Comparator<Transaction>() {
				@Override
				public int compare(Transaction t1, Transaction t2) {
				return t1.compareGasPrice(t2.gasPrice());
				}
				});
	}

	public Block getBlock()
	{
		return this.block;
	}

	public ArrayList<Transaction> getTransactions()
	{
		return this.transactions;
	}
}
