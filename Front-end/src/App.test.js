/**
 * @author [Sanjeet Kaul]
 * @email [kaulsanjeet2gmail.com]
 * @create date 2021-04-27 18:40:03
 * @modify date 2021-04-27 18:40:03
 * @desc [Group Project of Online Medicine Shopping System]
 */
import { render, screen } from '@testing-library/react';
import App from './App';

test('renders learn react link', () => {
  render(<App />);
  const linkElement = screen.getByText(/learn react/i);
  expect(linkElement).toBeInTheDocument();
});
