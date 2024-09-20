## REACT

**Lifting State Up:**
Lifting state up is a common pattern that react developers use to share state between multiple components. This process involves moving the state management from child components to a common ancestor (parent component)

**Example:**
- Moving State from chidren `b` to Parent `a`
- Lift the state up to Parent `a`
    - Manage the state for selectedMeal and selectedPeople in Order.
    - Pass the state and the state update functions to Step1 as props.
- Modify Step1 to use props for state:
    - Use the props for selectedMeal and selectedPeople.
    - Call the update functions from props to change the state.

**NOTES**
1. Use ` `(Backticks) for adding variable(js) in string in html.
2. 