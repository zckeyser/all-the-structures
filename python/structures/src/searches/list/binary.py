def contains(arr, value):
    if len(arr) == 1:
        return arr[0] == value
    elif not arr:
        return False

    index = int(len(arr) / 2)

    if arr[index] == value:
        return True
    elif arr[index] < value:
        return contains(arr[index + 1:], value)
    else:
        return contains(arr[:index], value)
