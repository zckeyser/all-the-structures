package dict

import "errors"

type KeyValueNode struct {
  key string
  value int
  next *KeyValueNode
}

type ChainingDict struct {
  size int
  buckets []*KeyValueNode
}

func NewChainingDict(initialSize int) *ChainingDict {
  out := new(ChainingDict)
  out.size = 0
  out.buckets = make([]*KeyValueNode, initialSize)

  return out
}

func (d *ChainingDict) Set(key string, value int) {
  if d.saturation() > saturationLimit { d.expand() }

  index := Hash(key) % len(d.buckets)
  newNode := &KeyValueNode{key, value, nil}

  if d.buckets[index] == nil {
    // empty bucket, just set it
    d.buckets[index] = newNode
    d.size++
  } else if d.buckets[index].key == key {
    // update existing value
    d.buckets[index].value = value
  } else {
    // collision, append it to the end of the bucket
    curr := d.buckets[index]

    // go to the last existing node
    for curr.next != nil {
      if curr.key == key {
        // update existing value
        curr.value = value
        return
      }

      curr = curr.next
    }

    // make sure the last node doesn't already have this key
    if curr.key == key {
      curr.value = value
    }

    // set the new node as the end node
    curr.next = newNode
    d.size++
  }
}

func (d *ChainingDict) Get(key string) (int, error) {
  index := Hash(key) % len(d.buckets)

  if d.buckets[index] == nil {
    return -1, errors.New("could not find key " + key)
  } else {
    node := d.buckets[index].findByKey(key)

    if node == nil { return -1, errors.New("could not find key " + key) }

    return node.value, nil
  }
}

func (node *KeyValueNode) findByKey(key string) *KeyValueNode {
  for curr := node; curr != nil; curr = curr.next {
    if curr.key == key {
      return curr
    }
  }

  return nil
}

// returns the current saturation level of the dictionary
func (d *ChainingDict) saturation() float32 {
  return float32(d.size) / float32(len(d.buckets))
}

// doubles the capacity of the dictionary to reduce saturation
func (d *ChainingDict) expand() {
  oldBuckets := d.buckets

  // increase bucket count
  d.buckets = make([]*KeyValueNode, len(d.buckets) * 2)
  d.size = 0

  // re-insert all the old key/value pairs
  for i := 0; i < len(oldBuckets); i++ {
    for curr := oldBuckets[i]; curr != nil; curr = curr.next {
      if curr != nil {
        d.Set(curr.key, curr.value)
      }
    }
  }
}
