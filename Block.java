

class Block
{
	private String blockHash;
	private String blockNumber;
	private int size;
	private String timeStamp; 
	private String totalDifficulty;
	private String miner;
	private String gasLimit;
	private String gasUsed;

	public Block(String blockHash, String blockNumber, int size, String timeStamp, String totalDifficulty, String miner, String gasLimit, String gasUsed) 
	{
		this.blockHash = blockHash;
		this.blockNumber = blockNumber;
		this.size = size;
		this.timeStamp = timeStamp;
		this.totalDifficulty = totalDifficulty;
		this.miner = miner;
		this.gasLimit = gasLimit;
		this.gasUsed = gasUsed;
	}

	public String blockId() 
	{
		return blockHash;
	} 

        public String blockNumber()
        {
                return blockNumber;
        }

        public String gasUsed()
        {
                return gasUsed;
        }


	public int compareGasLimit(String gasLimit) 
	{
		return Double.compare(Double.parseDouble(this.gasLimit), Double.parseDouble(gasLimit));
	}

	public String getGasLimit()
	{
		return this.gasLimit;
	}

        public int compareGasUsed(String gasUsed)
        {
		return Double.compare(Double.parseDouble(this.gasUsed), Double.parseDouble(gasUsed));
        }

        public String getGasUsed()
        {
                return this.gasUsed;
        }


	public static void printHeader()
	{
		System.out.println("block hash\tblock number\tsize\ttime stamp\ttotal difficulty\tminer\tgas limit\tgas used");
	}

	@Override
		public String toString() {
			return blockHash + "\t" + blockNumber + "\t" + size + "\t" + timeStamp + "\t" + totalDifficulty + "\t" + miner + "\t" + gasLimit + "\t" + gasUsed;
		}

}
