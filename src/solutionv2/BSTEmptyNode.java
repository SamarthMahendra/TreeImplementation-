package solutionv2;


import java.util.function.Consumer;

/**
 * This node represents an empty node in the binary search tree (i.e. the
 * leaves)
 */
public class BSTEmptyNode<T extends Comparable<T>> implements BSTNode<T> {
  @Override
  public BSTNode<T> insert(T data) {
    return new BSTElementNode(data,new BSTEmptyNode(),new BSTEmptyNode());
  }

  @Override
  public T minimum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  @Override
  public T maximum() throws NothingThereException {
    throw new NothingThereException("Tree does not have any data");
  }

  @Override
  public boolean contains(T data) {
    return false;
  }

  @Override
  public String toString() {
    return "";
  }

  @Override
  public void preorder(Consumer<T> consumer) {
    return;
  }

  @Override
  public void postorder(Consumer<T> consumer) {
    return;
  }

  @Override
  public BSTNode<T> copy() {
    return null;
  }

  @Override
  public boolean accept(BSTVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public boolean same(BSTNode<T> other) {
    BSTComparisonVisitor<T> visitor = new BSTComparisonVisitor<>(other);
    return accept(visitor);
  }

  @Override
  public boolean sameAsRootNode(BSTNode<T> other) {
    BSTComparisonVisitor<T> visitor = new BSTComparisonVisitor<>(other);
    return accept(visitor);
  }

  @Override
  public boolean sameAsLeafNode(BSTNode<T> other) {
    BSTComparisonVisitor<T> visitor = new BSTComparisonVisitor<>(other);
    return accept(visitor);
  }

}
