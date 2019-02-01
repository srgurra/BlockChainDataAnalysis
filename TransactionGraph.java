import java.util.*; 

public class TransactionGraph
{
	private HashMap<String, TransactionNode> graph;
	private HashMap<String, String> visited;

	public TransactionGraph()
	{
		graph = new HashMap<String, TransactionNode>();
	}

	public void addEdge(String from, String to)
	{
		TransactionNode node = null;
		TransactionNode newNode = new TransactionNode(to);

		if(graph.containsKey(from)) {
			node = graph.get(from);
			if(!node.searchTo(to)) {
				node.addNeighbour(newNode);
			}
		} else {
			node = new TransactionNode(from);	
			node.addNeighbour(newNode);
			graph.put(from, node);

		}
	}	
	
	public void printGraph()
	{
		System.out.println("Printing the Graph:");	
		System.out.println("Template:");
		System.out.println("Counter.\tNode Public Key\t-->\tconnected node (weight), connected node , ...");
		int index = 0;
		for (Map.Entry<String, TransactionNode> entry : graph.entrySet()) {
			index++;
			
			System.out.println(index + "\t" + entry.getKey() + "\t-->\t" + entry.getValue());
		}
	}

	public void printBFS(String startPoint)
	{
		HashMap<String, String> visited = new HashMap<String, String>();
		HashMap<String, Integer> pathLength = new HashMap<String, Integer>();

		System.out.println("NodeId - Shortest path(number of edges)");
		int nextIncrement = 0, currentDepth = 0;
		if(graph.containsKey(startPoint)) {
                        TransactionNode startNode = graph.get(startPoint);
			//ArrayList<ArrayList<TransactionNode> > queue = new ArrayList<ArrayList<TransactionNode> >();
			ArrayList<TransactionNode> queue = startNode.getAdjacencyList();
			
			int pathLen = 0;
			pathLength.put(startPoint, pathLen);

			pathLen++;
			for(TransactionNode newNode : startNode.getAdjacencyList()) {
				pathLength.put(newNode.getNodeName(), pathLen);
			}

			nextIncrement += queue.size();
                                        System.out.print(startNode.getNodeName() + " - ");
                                        System.out.println(pathLength.get(startNode.getNodeName()));

			while(!queue.isEmpty()) {
				TransactionNode node = queue.get(0); 
				currentDepth++;

				if(currentDepth > nextIncrement) {
					nextIncrement += queue.size();
					pathLen++;
				}

				if(!visited.containsKey(node.getNodeName())){
					for(TransactionNode newNode : node.getAdjacencyList()) {
						if(!visited.containsKey(newNode.getNodeName())){
							queue.add(newNode);
							pathLength.put(newNode.getNodeName(), pathLen);
						}
					}
					System.out.print(node.getNodeName() + " - ");
					System.out.println(pathLength.get(node.getNodeName()));

					visited.put(node.getNodeName(), node.getNodeName());
				}
				queue.remove(0);
			}
                } else {
			System.out.println("Node not present in from list");
                }
	}

	private void printDFSUtil(TransactionNode node)
	{
		if(!visited.containsKey(node.getNodeName())){
			visited.put(node.getNodeName(), node.getNodeName());
			for(TransactionNode newNode : node.getAdjacencyList()) {
				if(!visited.containsKey(newNode.getNodeName())){
					printDFSUtil(newNode);
				}
			}
			System.out.println(node.getNodeName());
		}
	}

	public void printDFS(String startPoint)
	{
		visited = new HashMap<String, String>();

		if(graph.containsKey(startPoint)) {
			System.out.println("Node Name");
			TransactionNode startNode = graph.get(startPoint);			
			printDFSUtil(startNode);
		} else {
                        System.out.println("Node not present in from list");
                }
	}
}


