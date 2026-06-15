# Lab 03: Basic Object-Oriented Techniques

## Cấu trúc dự án (Exercise 8 – Re-organize)

```
lab03/
├── answers.txt
│
├── AimsProject/
│   └── src/
│       └── hust/soict/dsai/
│           ├── aims/
│           │   ├── Aims.java                          ← main entry point
│           │   ├── cart/
│           │   │   └── Cart.java                      ← Exercise 2, 6
│           │   ├── disc/
│           │   │   └── DigitalVideoDisc.java           ← Exercise 2, 5, 6
│           │   └── store/
│           │       └── Store.java                      ← Exercise 7
│           └── test/
│               ├── cart/
│               │   └── CartTest.java                   ← Exercise 6 tests
│               ├── disc/
│               │   └── TestPassingParameter.java       ← Exercise 3, 4
│               └── store/
│                   └── StoreTest.java                  ← Exercise 7 tests
│
└── OtherProjects/
    └── src/
        └── hust/soict/dsai/
            └── garbage/                                ← Exercise 9
                ├── ConcatenationInLoops.java
                ├── GarbageCreator.java
                └── NoGarbage.java
```

## Tóm tắt các Exercise

| Exercise | Nội dung | File |
|----------|----------|------|
| 1 | Release Flow / branching (Git) | — (Git ops, xem answers.txt) |
| 2.1 | Overload `addDigitalVideoDisc` by type (array & varargs) | `Cart.java` |
| 2.2 | Overload `addDigitalVideoDisc` by param count (2 DVDs) | `Cart.java` |
| 3 | Pass-by-value demo + correct swap | `TestPassingParameter.java` |
| 4 | Eclipse debug (breakpoints, Step Into/Over/Return) | `TestPassingParameter.java` |
| 5 | Classifier (`nbDigitalVideoDiscs`) & Instance (`id`) member | `DigitalVideoDisc.java` |
| 6 | `print()`, `searchById()`, `searchByTitle()`, `isMatch()`, `toString()` | `Cart.java`, `DigitalVideoDisc.java`, `CartTest.java` |
| 7 | `Store` class với `addDVD()` / `removeDVD()` | `Store.java`, `StoreTest.java` |
| 8 | Tổ chức lại project theo packages | cả project |
| 9 | `String` vs `StringBuilder` vs `StringBuffer` | `ConcatenationInLoops.java`, `GarbageCreator.java`, `NoGarbage.java` |

## Git – Release Flow branches cho lab này

```bash
git checkout -b refactor/apply-release-flow    # Exercise 1
git checkout -b topic/method-overloading        # Exercise 2
git checkout -b topic/passing-parameter         # Exercise 3
git checkout -b topic/class-members             # Exercise 5
git checkout -b feature/print-cart              # Exercise 6 (print)
git checkout -b feature/search-cart             # Exercise 6 (search)
git checkout -b topic/store                     # Exercise 7
git checkout -b refactor/packages               # Exercise 8
git checkout -b topic/memory-management-string  # Exercise 9
```

Sau khi merge tất cả vào master, tạo:
```bash
# Trên GitHub GUI: tạo branch release/lab03 từ master
```

## Kết quả chạy CartTest (mẫu)

```
The disc has been added to cart: The Lion King
The disc has been added to cart: Star Wars
The disc has been added to cart: Aladin
The disc has been added to cart: The Lion Guard

***********************CART***********************
Ordered Items:
1. DVD - The Lion King - Animation - Roger Allers - 87 min: 19.95 $
2. DVD - Star Wars - Science Fiction - George Lucas - 87 min: 24.95 $
3. DVD - Aladin - Animation - N/A - 0 min: 18.99 $
4. DVD - The Lion Guard - Animation - Howy Parkins - 60 min: 15.0 $
Total cost: 78.89 $
***************************************************

Searching for DVD with ID = 1 ...
Found: DVD - The Lion King - Animation - Roger Allers - 87 min: 19.95 $

Searching for DVD with title containing "lion" ...
Found: DVD - The Lion King - Animation - Roger Allers - 87 min: 19.95 $
Found: DVD - The Lion Guard - Animation - Howy Parkins - 60 min: 15.0 $
```
