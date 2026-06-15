================================================================================
Lab 05: GUI Programming - Answers
================================================================================

SECTION 1.3 - Compare Swing and AWT elements

Q: What are the differences between Swing and AWT?

1. Top-level Containers:
   - AWT: Frame (top-level container, application extends Frame directly)
   - Swing: JFrame (application extends JFrame, uses getContentPane() to add components)

2. Component class names:
   - AWT: TextField, Label, Button, Panel, ...
   - Swing: JTextField, JLabel, JButton, JPanel, ... (all prefixed with 'J')

3. Key structural difference:
   - In AWT, components are added directly to the Frame.
   - In Swing, JComponents (lightweight) MUST be added to the content-pane of the
     top-level container, not directly to the JFrame.
     Example: Container cp = getContentPane(); cp.add(component);

4. Rendering:
   - AWT uses native OS components (heavyweight) - looks different on each OS.
   - Swing uses its own rendering engine (lightweight) - consistent look across OS.

================================================================================

SECTION 13 - Exception Hierarchy Tree

PlayerException inherits from Exception (java.lang.Exception).
LimitExceededException inherits from Exception (java.lang.Exception).

Exception hierarchy:
    java.lang.Exception
    ├── PlayerException  (hust.soict.dsai.aims.exception)
    │   - Thrown when a Media cannot be played (e.g., length <= 0)
    │   - Used in: DigitalVideoDisc.play(), Track.play(), CompactDisc.play()
    │
    └── LimitExceededException  (hust.soict.dsai.aims.exception)
        - Thrown when cart exceeds MAX_NUMBERS_ORDERED (20 items)
        - Used in: Cart.addMedia()

================================================================================

SECTION 14 - What happens when you don't update Aims to catch exceptions?

If the Aims class does not catch PlayerException, the compiler will report a compile-time
error because PlayerException is a CHECKED exception (it extends Exception, not
RuntimeException). Every method that calls play() MUST either:
  a) Catch the exception with try-catch, OR
  b) Declare it with "throws PlayerException" in the method signature.

Without handling: the program will fail to compile.

================================================================================

SECTION 15 - equals() method of Media class

Two Media objects are equal if they have the same title (case-sensitive).
Implementation checks:
  - NullPointerException: handled by checking (obj == null) and (title == null)
  - ClassCastException: handled by using instanceof before casting

================================================================================
