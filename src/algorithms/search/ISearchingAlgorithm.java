package algorithms.search;

public interface ISearchingAlgorithm {
    Solution solve(ISearchable Is);
    int getNumOfVisitedNodes();
}