package solutionv2;

public class BSTComparisonVisitor<T extends Comparable<T>> implements BSTVisitor<T> {
  private BSTNode<T> otherRoot;

  public BSTComparisonVisitor(BSTNode<T> otherRoot) {
    this.otherRoot = otherRoot;
  }

  @Override
  public boolean visit(BSTEmptyNode<T> node) {
    return otherRoot instanceof BSTEmptyNode;
  }

  @Override
  public boolean visit(BSTElementNode<T> node) {
    if (otherRoot instanceof BSTElementNode) {
      BSTElementNode<T> otherElementNode = (BSTElementNode<T>) otherRoot;
      return node.getData().equals(otherElementNode.getData());
    }
    return false;
  }
}
