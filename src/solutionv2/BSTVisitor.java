package solutionv2;

public interface BSTVisitor<T extends Comparable<T>> {
  boolean visit(BSTEmptyNode<T> node);
  boolean visit(BSTElementNode<T> node);
}
