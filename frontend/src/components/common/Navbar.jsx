import { Link } from "react-router-dom";

function Navbar() {
  return (
    <nav className="bg-blue-600 text-white">
      <div className="max-w-7xl mx-auto flex items-center justify-between px-6 py-4">

        {/* Logo */}
        <Link to="/" className="text-3xl font-bold">
          Catch Up
        </Link>

        {/* Navigation Links */}
        <div className="flex gap-6 text-lg">
          <Link to="/">Home</Link>
          <Link to="/events">Events</Link>
          <Link to="/create-event">Create Event</Link>
        </div>

        {/* Authentication */}
        <div className="flex gap-4">
          <Link
            to="/login"
            className="bg-white text-blue-600 px-4 py-2 rounded-md font-semibold"
          >
            Login
          </Link>

          <Link
            to="/register"
            className="border border-white px-4 py-2 rounded-md"
          >
            Register
          </Link>
        </div>

      </div>
    </nav>
  );
}

export default Navbar;