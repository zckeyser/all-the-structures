package core

import "testing"
import "fmt"

func TestPriorityQueueOnePriority(t *testing.T) {
  q := new(PriorityQueue)

  for i := 0; i < 100; i++ {
    q.Enqueue(0, i)
  }

  for i := 0; i < 100; i++ {
    if result, err := q.Dequeue(); result != i || err != nil {
      t.Error(fmt.Sprintf("expected %d to equal %d or had error: %s", result, i, err))
    }
  }
}

func TestPriorityQueueManyPriorities(t *testing.T) {
  q := new(PriorityQueue)

  for i := 0; i < 100; i++ {
    q.Enqueue(0, 100 - i)
  }

  for i := 0; i < 100; i++ {
    if result, err := q.Dequeue(); result != 100 - i || err != nil {
      t.Error(fmt.Sprintf("expected %d to equal %d or had error: %s", result, i, err))
    }
  }
}
