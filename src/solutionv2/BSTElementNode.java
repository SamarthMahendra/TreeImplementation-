package solutionv2;

import java.util.function.Consumer;

/**
 * This class represents a data-containing node of the binary search tree
 * It mutates on all relevant operations
 */
public class BSTElementNode<T extends Comparable<T>> implements BSTNode<T> {
  private BSTNode<T> left;
  private BSTNode<T> right;
  private T data;

  public BSTElementNode(T data,BSTNode<T> left,BSTNode<T> right) {
    this.data = data;
    this.left = left;
    this.right = right;
  }
  @Override
  public BSTNode insert(T data) {
    if (data.compareTo(this.data)<0) {
      this.left = this.left.insert(data);
    } else if (data.compareTo(this.data)>0) {
      this.right = this.right.insert(data);
    }
    return this;
  }

  @Override
  public T minimum() {
    T minimum;

    try {
      minimum = this.left.minimum();
    }
    catch (NothingThereException e) {
      minimum = this.data;
    }
    return minimum;
  }

  @Override
  public T maximum() {
    T maximum;

    try {
      maximum = this.right.maximum();
    }
    catch (NothingThereException e) {
      maximum = this.data;
    }

    return maximum;
  }

  @Override
  public boolean contains(T data) {
    int compareResult = data.compareTo(this.data);

    if (compareResult==0)  {
      return true;
    }
    else if (compareResult<0) {
      return this.left.contains(data);
    }
    else {
      return this.right.contains(data);
    }
  }

  @Override
  public String toString() {
    String left,right,middle;

    middle = this.data.toString();
    left = this.left.toString();
    right = this.right.toString();
    if (left.length()>0) left = left + " ";
    if (right.length()>0) right = " " + right;
    return left + middle + right;
  }

  @Override
  public void preorder(Consumer<T> consumer) {
    consumer.accept(data);
    this.left.preorder(consumer);
    this.right.preorder(consumer);
  }


  @Override
  public void postorder(Consumer<T> consumer) {
    this.left.postorder(consumer);
    this.right.postorder(consumer);
    consumer.accept(data);
  }

  @Override
  public BSTNode<T> copy() {
    return copyHelper(this);
  }

  private BSTNode<T> copyHelper(BSTNode<T> node) {
    if (node == null) {
      return null;
    }

    BSTNode<T> leftCopy = null;
    BSTNode<T> rightCopy = null;

    if (node instanceof BSTElementNode) {
      if (((BSTElementNode<T>) node).getLeft() != null) {
        leftCopy = copyHelper(((BSTElementNode<T>) node).getLeft());
      } else {
        leftCopy = new BSTEmptyNode<>();
      }

      if (((BSTElementNode<T>) node).getRight() != null) {
        rightCopy = copyHelper(((BSTElementNode<T>) node).getRight());
      } else {
        rightCopy = new BSTEmptyNode<>();
      }

      return new BSTElementNode<>(((BSTElementNode<T>) node).getData(), leftCopy, rightCopy);
    } else {
      // Handle the case when the node is an instance of BSTEmptyNode
      return new BSTEmptyNode<>();
    }
  }






  @Override
  public boolean accept(BSTVisitor<T> visitor) {
    return visitor.visit(this);
  }

  public T getData() {
    return data;
  }

  public BSTNode<T> getLeft(){
    return this.left;
  }

  public BSTNode<T> getRight(){
    return this.right;
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
