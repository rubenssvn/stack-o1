package br.com.beblue;

import org.junit.Assert;
import org.junit.Test;

public class StackTest {

	// void push(Integer value)

	@Test
	public void test_push_with_empty_stack() {
		// Arrange
		Integer itemToPush = 1;
		Stack stack = new Stack();

		// Act
		stack.push(itemToPush);

		// Assert
		Integer min = stack.min();
		Assert.assertEquals(itemToPush, min);
	}

	@Test
	public void test_push_with_a_single_value_pushing_a_lower_value() {
		// Arrange
		Integer preExistingItem = 2;
		Integer itemToPush = 1;

		Stack stack = new Stack();
		stack.push(preExistingItem);

		// Act
		stack.push(itemToPush);

		// Assert
		Integer min = stack.min();
		Assert.assertEquals(itemToPush, min);
	}

	@Test
	public void test_push_with_a_single_value_pushing_a_higher_value() {
		// Arrange
		Integer preExistingItem = 2;
		Integer itemToPush = 3;

		Stack stack = new Stack();
		stack.push(preExistingItem);

		// Act
		stack.push(itemToPush);

		// Assert
		Integer min = stack.min();
		Assert.assertEquals(preExistingItem, min);
	}

	@Test
	public void test_push_with_a_single_value_pushing_same_value() {
		// Arrange
		Integer preExistingItem = 2;
		Integer itemToPush = 2;

		Stack stack = new Stack();
		stack.push(preExistingItem);

		// Act
		stack.push(itemToPush);

		// Assert
		Integer min = stack.min();
		Assert.assertEquals(itemToPush, min);
	}

	// Integer pop()
	
	@Test(expected = EmptyStackException.class)
	public void test_pop_with_empty_stack() {
		// Arrange
		Stack stack = new Stack();

		// Act
		stack.pop();
	}
	
	@Test
	public void test_pop_with_stack_with_a_single_item() {
		// Arrange
		Integer item = 1;
		Stack stack = new Stack();
		stack.push(item);

		// Act
		Integer removedItem =  stack.pop();
		
		// Assert
		Assert.assertEquals(item,  removedItem);
	}
	
	@Test
	public void test_pop_with_stack_with_two_items_() {
		// Arrange
		Integer firstItem = 2;
		Integer secondItem = 1;
		Stack stack = new Stack();
		stack.push(firstItem);
		stack.push(secondItem);

		// Act
		Integer removedItem =  stack.pop();
		
		// Assert
		Assert.assertEquals(secondItem,  removedItem);
	}
	
	// Integer min()
	
	@Test(expected = EmptyStackException.class)
	public void test_min_with_empty_stack() {
		// Arrange
		Stack stack = new Stack();

		// Act
		stack.min();
	}
	
	@Test
	public void test_min_with_a_single_item() {
		// Arrange
		Integer item = 1;
		Stack stack = new Stack();
		stack.push(item);

		// Act
		Integer min = stack.min();
		
		// Assert
		Assert.assertEquals(item, min);
	}
	
    @Test
	public void test_min_with_two_items() {
		// Arrange
		Integer lowerItem = 1;
		Integer higherItem = 2;
		Stack stack = new Stack();
		stack.push(lowerItem);
		stack.push(higherItem);

		// Act
		Integer min = stack.min();
		
		// Assert
		Assert.assertEquals(lowerItem, min);
	}
	
}