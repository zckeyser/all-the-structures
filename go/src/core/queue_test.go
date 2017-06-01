package core

import "testing"
import "fmt"

func TestQueueEnqueueOne(t *testing.T) {
  s := new(Queue)

  s.Enqueue(1)

  result, err := s.Dequeue()

  if err != nil {
    t.Error(fmt.Sprintf("got error: %s", err))
  }

  if result != 1 {
    t.Error(fmt.Sprintf("expected 1, got %d", result))
  }
}

func TestQueueEnqueueMultiple(t *testing.T) {
  s := new(Queue)

  for i := 0; i < 100; i++ {
    s.Enqueue(i)
  }

  for i := 0; i < 100; i++ {
    if result, err := s.Dequeue(); err != nil {
      t.Error(fmt.Sprintf("got error: %s", err))
    } else if result != i {
      t.Error(fmt.Sprintf("expected %d to equal %d", result, i))
    }
  }
}
