
import java.io.*;


public class LoadBlockchain
{
	private String blockFileName;
	private String transactionFileName;

	LoadBlockchain(String blockFileName, String transactionFileName)
	{
		this.blockFileName = blockFileName;
		this.transactionFileName = transactionFileName;
	}

	public BlockAnalytics loadBlocksOnly() throws Exception
	{
		BlockAnalytics analytics = new BlockAnalytics();
		String[] nextRecord;
		String line;
		BufferedReader br;

		br = new BufferedReader(new FileReader(blockFileName));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRecord = line.split(",");
			if(nextRecord.length >= 8) {
				analytics.addBlock(nextRecord[0], nextRecord[1], Integer.parseInt(nextRecord[2]), nextRecord[3], nextRecord[4], nextRecord[5], nextRecord[6], nextRecord[7]);

			}
		}

		return analytics;
	}

	public BlockAnalytics loadBlockTransactions() throws Exception
	{
		BlockAnalytics analytics = new BlockAnalytics();
		String[] nextRecord;
		String line;
		BufferedReader br;
		br = new BufferedReader(new FileReader(blockFileName));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRecord = line.split(",");
			if(nextRecord.length >= 8) {
				analytics.addBlock(nextRecord[0], nextRecord[1], Integer.parseInt(nextRecord[2]), nextRecord[3], nextRecord[4], nextRecord[5], nextRecord[6], nextRecord[7]);
			}
		}

		br = new BufferedReader(new FileReader(transactionFileName));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRecord = line.split(",");
			if(nextRecord.length >= 9){
				analytics.addTransaction(nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5], nextRecord[6], nextRecord[7], nextRecord[8]);
			}
		}

		return analytics;
	}

	public TransactionAnalytics loadTransactionsOnly() throws Exception
	{
		TransactionAnalytics analytics = new TransactionAnalytics();
		String[] nextRecord;
		String line;
		BufferedReader br;

		br = new BufferedReader(new FileReader(transactionFileName));
		line = br.readLine();
		while ((line = br.readLine()) !=null) {
			nextRecord = line.split(",");
			if(nextRecord.length >= 9){
				analytics.addTransaction(nextRecord[0], nextRecord[1], nextRecord[2], nextRecord[3], nextRecord[4], nextRecord[5], nextRecord[6], nextRecord[7], nextRecord[8]);
			}
		}

		return analytics;
	}

	public TransactionGraph loadTransactionGraph() throws Exception
        {
                TransactionGraph graph = new TransactionGraph();
                String[] nextRecord;
                String line;
                BufferedReader br;

                br = new BufferedReader(new FileReader(transactionFileName));
                line = br.readLine();
                while ((line = br.readLine()) !=null) {
                        nextRecord = line.split(",");
                        if(nextRecord.length >= 9){
				graph.addEdge(nextRecord[2], nextRecord[3]);
                        }
                }

                return graph;
        }

}


