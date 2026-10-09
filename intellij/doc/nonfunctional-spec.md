Non-functional Specifications:

- Usability:
  - Accessible language
  - Clear font sizes and text size
  - Clear button placement
  - Colors associated with color blindness should be avoided
  - Color coded payment status
  - Color coded trips (greyed out past trips)

- Reliability:
  - If external systems fail (e.g. Zelle, Venmo, Paypal) try to solve with a local solution.
    - Payment authorization service failure.
    - Ask user if they paid their debt in cash.
    - If not, leave the status of the expense as "In Progress" so that they can pay at a later time.

- Performance:
  - Live updates/efficient calculations
  - One bottleneck is external payment authorization. Timeout after 30 seconds.

- Supportability:
  - Internationalization of displayed text (text, units, number and date, currency)

- Implementation:
  - Runs on Android
  - Written in Java

- External Interfaces:
  - The goal is to eventually connect to Zelle, Venmo, Paypal, etc.

- Legal:
  - None