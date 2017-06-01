package core

import "testing"
import "fmt"

func TestStackPushOne(t *testing.T) {
  s := new(Stack)

  s.Push(1)

  result, err := s.Pop()

  if err != nil {
    t.Error(fmt.Sprintf("got error: %s", err))
  }

  if result.(int) != 1 {
    t.Error(fmt.Sprintf("expected 1, got %d", result.(int)))
  }
}

func TestStackPushMultiple(t *testing.T) {
  s := new(Stack)

  for i := 0; i < 100; i++ {
    s.Push(i)
  }

  for i := 99; i >= 0; i-- {
    if result, err := s.Pop(); err != nil {
      t.Error(fmt.Sprintf("got error: %s", err))
    } else if result.(int) != i {
      t.Error(fmt.Sprintf("expected %d to equal %d", result.(int), i))
    }
  }
}
