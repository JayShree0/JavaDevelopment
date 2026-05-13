<!-- Tags in html
-------------


<h1> to <h6> heading
<p> paragraph
<a> anchor tag
<img> image
<br> line break
<hr> horizontal line
<strong> bold text
<em> italic text
<ol> ordered list
<ul> unordered list
<table> table
<form> form -->

# HTML Tags Reference

A simple and clean list of common and important HTML tags.

---

## **1. Pair Tags (Open–Close Tags)**

Examples:

* `<p>...</p>` — Paragraph
* `<h1>...</h1>` to `<h6>...</h6>` — Headings
* `<a href="">...</a>` — Anchor / Link
* `<div>...</div>` — Division block
* `<span>...</span>` — Inline container
* `<form>...</form>` — Form container

---

## **2. Self‑Closing Tags (Void Tags)**

Examples:

* `<br>` — Line break
* `<hr>` — Horizontal line
* `<img src="" alt="">` — Image
* `<input type="">` — Input field
* `<meta charset="">` — Metadata
* `<link rel="stylesheet" href="">` — Link external CSS

---

## **Common HTML Tags**

### **Text Formatting Tags**

* `<strong>` — Bold (semantic)
* `<b>` — Bold
* `<em>` — Italic (semantic)
* `<i>` — Italic
* `<u>` — Underline
* `<mark>` — Highlight text
* `<small>` — Smaller text
* `<sub>` — Subscript
* `<sup>` — Superscript

---

### **List Tags**

* `<ol>` — Ordered list
* `<ul>` — Unordered list
* `<li>` — List item
* `<dl>` — Description list
* `<dt>` — Term
* `<dd>` — Description

---

### **Table Tags**

* `<table>` — Table
* `<tr>` — Table row
* `<td>` — Table data cell
* `<th>` — Table header cell
* `<thead>` — Table head
* `<tbody>` — Table body
* `<tfoot>` — Table footer

---

### **Form Tags**

* `<label for="id">` — Connects text to an input field
* `<form>` — Form
* `<input>` — Input field
* `<textarea>` — Multi‑line text
* `<select>` — Dropdown
* `<option>` — Dropdown option
* `<button>` — Button

---

### **Structural & Layout Tags**

* `<header>` — Top section
* `<footer>` — Bottom section
* `<nav>` — Navigation menu
* `<section>` — Section
* `<article>` — Article content
* `<aside>` — Sidebar
* `<main>` — Main content

---

### **Media Tags**

* `<audio>` — Audio player
* `<video>` — Video player
* `<source>` — Media source
* `<canvas>` — Drawing area

---

### **Document Structure Tags**

* `<!DOCTYPE html>` — Defines HTML5 document
* `<html>` — Root element
* `<head>` — Metadata container
* `<title>` — Page title
* `<body>` — Page content

---

## **Semantic HTML5 Tags**

These tags give meaning to the structure of your page.

* `<header>` — Defines header section
* `<footer>` — Defines footer section
* `<nav>` — Navigation area
* `<main>` — Main content area
* `<section>` — Logical content section
* `<article>` — Independent article content
* `<aside>` — Sidebar content
* `<figure>` — Image or illustration wrapper
* `<figcaption>` — Caption for a figure
* `<details>` — Expandable/collapsible content
* `<summary>` — Summary for a details block

---

## **Important CSS Tags / Properties**

* `color` — Text color
* `background-color` — Set background color
* `margin` — Outer spacing
* `padding` — Inner spacing
* `border` — Add border around elements
* `font-size` — Text size
* `font-weight` — Thickness of text
* `display` — Layout type (block, inline, flex, grid)
* `flex` — Flexbox layout
* `grid` — Grid layout
* `width` / `height` — Element size
* `position` — Positioning (static, relative, absolute, fixed)
* `text-align` — Align text (left/center/right)
* `box-shadow` — Add shadow
* `cursor` — Mouse cursor style

---

## **HTML5 APIs (Important Ones)**

* **Geolocation API** — Get user location
* **LocalStorage / SessionStorage** — Save data in browser
* **Canvas API** — Draw shapes & graphics
* **Web Workers** — Background threads for performance
* **Fetch API** — Make HTTP requests
* **Drag & Drop API** — Dragging UI elements
* **Notifications API** — Show system notifications
* **Media API** — Access camera/mic (`getUserMedia`)

---

## **Styled README Table Version**

### HTML Tags Cheat Sheet (Table Format)

| Category   | Tag            | Description              |
| ---------- | -------------- | ------------------------ |
| Headings   | `<h1>–<h6>`    | Title headings           |
| Paragraph  | `<p>`          | Paragraph text           |
| Link       | `<a>`          | Anchor / hyperlink       |
| Image      | `<img>`        | Display image            |
| Line Break | `<br>`         | New line                 |
| Strong     | `<strong>`     | Bold text                |
| Emphasis   | `<em>`         | Italic text              |
| List       | `<ol>`, `<ul>` | Ordered / unordered list |
| List Item  | `<li>`         | List element             |
| Table      | `<table>`      | Table structure          |
| Form       | `<form>`       | Form container           |
| Input      | `<input>`      | Form input               |
| Div        | `<div>`        | Block container          |
| Span       | `<span>`       | Inline container         |

---

## **Bonus: Useful HTML Entities**

* `&lt;` — <
* `&gt;` — >
* `&amp;` — &
* `&copy;` — ©
* `&nbsp;` — Non‑breaking space

---

If you want, I can add **CSS tags**, **HTML5 APIs**, or convert this into a styled README with tables.


# CSS Cheat Sheet (Clean & Clean Format)

## **Types of CSS (Priority Order)**

1. **Inline CSS** — p1 (Highest)
2. **Internal CSS** — p2 (Medium)
3. **External CSS** — p3 (Low) (Best practice)

---

# **Properties (Props)**

1. **width**
2. **height**
3. **font-size**
4. **font-weight**
5. **color / background-color**
6. **units**
7. **Selectors**

   * Universal (`*`)
   * Element (`h1`, `p`)
   * ID (`#id`)
   * Class (`.class`)

---

# **CSS Selectors Guide**

A clean and separate section containing all major CSS selectors.

---

## **1. Basic Selectors**

* `element` — Type selector (e.g., `p`, `div`, `h1`)
* `.class` — Class selector
* `#id` — ID selector
* `*` — Universal selector

---

## **2. Combinators**

* `A B` — Descendant selector
* `A > B` — Direct child selector
* `A + B` — Adjacent sibling selector
* `A ~ B` — General sibling selector

---

## **3. Pseudo-classes**

* `:hover` — Hover state
* `:focus` — Focused input
* `:active` — Active state
* `:first-child` — First child element
* `:last-child` — Last child element
* `:nth-child(n)` — Select nth element

---

## **4. Pseudo-elements**

* `::before` — Insert content before element
* `::after` — Insert content after element
* `::first-line` — First line of text
* `::selection` — Selected text

---

## **5. Grouping Selectors**

* `h1, p, div` — Apply same style to multiple elements

---

## **6. Units**

* `px`
* `%`
* `vh`
* `vw`
* `em`
* `rem`

---

## **7. CSS Positioning**

* `position: static;` — Default flow
* `position: relative;` — Relative to itself
* `position: absolute;` — Relative to nearest positioned parent
* `position: fixed;` — Fixed to viewport
* `position: sticky;` — Sticks based on scroll

---

## **8. Display Types**

* `display: inline;` — No new line, width ignored
* `display: block;` — Full width, new line
* `display: inline-block;` — Inline + supports width/height
* `display: flex;` — Flexbox layout
* `display: grid;` — Grid layout

---

## **9. Flexbox Properties**

### **justify-content** — Horizontal alignment (main axis)

* `flex-start`
* `center`
* `flex-end`
* `space-between`
* `space-around`

### **align-items** — Vertical alignment (cross axis)

* `flex-start`
* `center`
* `flex-end`
* `stretch`

### **flex-direction** — Layout direction

* `row`
* `row-reverse`
* `column`
* `column-reverse`

---


# HTML Element Display Types

## ✅ Inline Elements (Do NOT take full width)

Inline elements **stay within a line** and usually **do not support width/height**.

### Common inline tags:

* `<a>`
* `<span>`
* `<img>` *(inline but supports width/height)*
* `<strong>`
* `<b>`
* `<i>`
* `<em>`
* `<u>`
* `<small>`
* `<label>`
* `<abbr>`
* `<cite>`
* `<code>`
* `<time>`
* `<sup>` / `<sub>`
* `<mark>`
* `<q>`
* `<br>`

### Behavior

* ✔ Occupy only required space
* ✔ Sit next to other inline elements
* ❌ `width` and `height` usually don't work
* ❌ Vertical margins (`margin-top`, `margin-bottom`) don’t work
* ❗ `transform: scale()` works best when converted to inline-block

---

## ✅ Block Elements (Take full width, start on a new line)

Block elements **start on a new line** and take the **full width** available.

### Common block tags:

* `<div>`
* `<p>`
* `<h1>` – `<h6>`
* `<header>`
* `<footer>`
* `<section>`
* `<article>`
* `<nav>`
* `<main>`
* `<aside>`
* `<ul>`, `<ol>`, `<li>`
* `<form>`
* `<table>`
* `<figure>`
* `<blockquote>`

### Behavior

* ✔ Always start on a new line
* ✔ Take 100% width by default
* ✔ Fully support `width`, `height`, `margin`, `padding`

---

## ⚡ Inline-Block Elements (Inline but allow width/height)

Inline-block elements behave like inline elements but **support all size properties**.

### Default inline-block elements:

* `<img>`
* `<input>`
* `<button>`
* `<textarea>`
* `<select>`

### Behavior

* ✔ Sit inline with other elements
* ✔ You can set `width` and `height`
* ✔ Perfect for buttons and icons

---

## ⭐ Why `display: inline-block` Fixes Button Hover Scaling

`<a>` is an inline element, so scaling animations can behave incorrectly.

To fix the hover effect:

```css
display: inline-block;
```

This makes scaling (`transform: scale()`) smooth and reliable.








Here is a **clean, consistent, rewritten README.md**, with **Grid** added and formatting improved.
Tone remains simple and calm.

---

# HTML & CSS Cheat Sheet

A concise reference for commonly used HTML tags, CSS properties, selectors, display types, flexbox, and grid.

---

# **HTML Tags Reference**

## **1. Pair Tags (Open–Close Tags)**

Examples:

* `<p>...</p>` — Paragraph
* `<h1>...</h1>` to `<h6>...</h6>` — Headings
* `<a href="">...</a>` — Link
* `<div>...</div>` — Block container
* `<span>...</span>` — Inline container
* `<form>...</form>` — Form wrapper

---

## **2. Self-Closing Tags (Void Tags)**

Examples:

* `<br>` — Line break
* `<hr>` — Horizontal line
* `<img src="" alt="">` — Image
* `<input type="">` — Form input
* `<meta charset="">` — Metadata
* `<link rel="stylesheet" href="">` — Stylesheet link

---

## **Common HTML Tags**

### **Text Formatting**

* `<strong>` — Bold (semantic)
* `<b>` — Bold
* `<em>` — Italic (semantic)
* `<i>` — Italic
* `<u>` — Underline
* `<mark>` — Highlight
* `<small>` — Smaller text
* `<sub>` — Subscript
* `<sup>` — Superscript

---

### **List Tags**

* `<ol>` — Ordered list
* `<ul>` — Unordered list
* `<li>` — List item
* `<dl>` — Description list
* `<dt>` — Term
* `<dd>` — Definition

---

### **Table Tags**

* `<table>` — Table
* `<tr>` — Row
* `<td>` — Data cell
* `<th>` — Header cell
* `<thead>` — Table head
* `<tbody>` — Table body
* `<tfoot>` — Table footer

---

### **Form Tags**

* `<form>` — Form container
* `<label>` — Input label
* `<input>` — Input field
* `<textarea>` — Multi-line input
* `<select>` — Dropdown
* `<option>` — Dropdown option
* `<button>` — Button

---

### **Structural & Layout Tags**

* `<header>`
* `<footer>`
* `<section>`
* `<article>`
* `<nav>`
* `<aside>`
* `<main>`

---

### **Media Tags**

* `<audio>`
* `<video>`
* `<source>`
* `<canvas>`

---

### **Document Structure**

* `<!DOCTYPE html>`
* `<html>`
* `<head>`
* `<title>`
* `<body>`

---

## **Semantic HTML5 Tags**

* `<header>`
* `<footer>`
* `<nav>`
* `<main>`
* `<section>`
* `<article>`
* `<aside>`
* `<figure>`
* `<figcaption>`
* `<details>`
* `<summary>`

---

# **CSS Cheat Sheet**

## **Types of CSS (Priority Order)**

1. Inline CSS — Highest
2. Internal CSS — Medium
3. External CSS — Lowest (recommended)

---

# **Important CSS Properties**

* color
* background-color
* margin
* padding
* border
* font-size
* font-weight
* display
* flex
* grid
* width / height
* position
* text-align
* box-shadow
* cursor

---

# **CSS Selectors**

## **1. Basic Selectors**

* `element`
* `.class`
* `#id`
* `*`

---

## **2. Combinators**

* `A B` — descendant
* `A > B` — direct child
* `A + B` — adjacent sibling
* `A ~ B` — general sibling

---

## **3. Pseudo-classes**

* `:hover`
* `:focus`
* `:active`
* `:first-child`
* `:last-child`
* `:nth-child(n)`

---

## **4. Pseudo-elements**

* `::before`
* `::after`
* `::first-line`
* `::selection`

---

## **5. Grouping**

* `h1, p, div`

---

# **CSS Units**

* px
* %
* vh
* vw
* em
* rem

---

# **CSS Positioning**

* static
* relative
* absolute
* fixed
* sticky

---

# **Display Types**

## **Inline (does not take full width)**

Common tags:
`<a>`, `<span>`, `<img>`, `<strong>`, `<i>`, `<label>`

Behavior:

* sits in line
* ignores width/height
* top/bottom margins unreliable

---

## **Block (takes full width)**

Common tags:
`<div>`, `<p>`, `<h1>–<h6>`, `<section>`, `<ul>`, `<form>`

Behavior:

* starts on new line
* supports width/height fully

---

## **Inline-block**

Common examples:
`<img>`, `<input>`, `<button>`

Behavior:

* sits inline
* supports width/height

---

# **Flexbox Cheat Sheet**

### **Main properties**

**justify-content**

* flex-start
* center
* flex-end
* space-between
* space-around

**align-items**

* flex-start
* center
* flex-end
* stretch

**flex-direction**

* row
* row-reverse
* column
* column-reverse

---

# **CSS Grid (New Section)**

## **Creating a grid**

```css
.grid {
  display: grid;
  grid-template-columns: repeat(3, 1fr);
  gap: 20px;
}
```

---

## **Important Grid Properties**

* `display: grid`
* `grid-template-columns`
* `grid-template-rows`
* `gap` / `row-gap` / `column-gap`
* `grid-column`
* `grid-row`
* `place-items`
* `justify-items`
* `align-items`

---

## **Grid Examples**

### **3 equal columns**

```css
grid-template-columns: repeat(3, 1fr);
```

### **2-1 layout**

```css
grid-template-columns: 2fr 1fr;
```

### **Auto-fit responsive grid**

```css
grid-template-columns: repeat(auto-fit, minmax(250px, 1fr));
```

---

# **HTML Element Display Types (Quick Reference)**

## Inline Elements

* `<a>`, `<span>`, `<img>`, `<b>`, `<i>`, `<label>`, `<mark>`, `<br>`

## Block Elements

* `<div>`, `<p>`, `<h1>–<h6>`, `<section>`, `<article>`, `<ul>`, `<form>`

## Inline-Block Elements

* `<img>`, `<button>`, `<input>`, `<select>`

---

# **Scaling Fix for Inline Elements**

`<a>` is inline, so hover scaling works properly after:

```css
display: inline-block;
```

---

