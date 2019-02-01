import java.util.*; 

class TransactionNode
{
	private String to;
	private ArrayList<TransactionNode> adjacencyList; 

	public TransactionNode(String to) 
	{
		this.to = to;
		adjacencyList = new ArrayList<TransactionNode>();
	}

	public void addNeighbour(TransactionNode node)
	{
		adjacencyList.add(node);
	}

	public ArrayList<TransactionNode> getAdjacencyList()
	{
		return adjacencyList;
	}

	public String getNodeName()
	{
		return to;
	}

	public boolean searchTo(String to)
	{
		boolean find = false;
		for(TransactionNode node : adjacencyList) {
			if(node.getNodeName().equals(to)) {
				return true;
			}
		}
		return find;
	}

	@Override
	public String toString()
	{
		String retVal = "" + to;
		for(TransactionNode node : adjacencyList) {
			retVal += ", "+node.getNodeName();	
		}
		return retVal;
	}
}
