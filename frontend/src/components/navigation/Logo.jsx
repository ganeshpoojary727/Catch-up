import { Link } from "react-router-dom";
import { Sparkles } from "lucide-react";

function Logo() {
  return (
    <Link to="/" className="flex items-center gap-3">
      <div className="bg-indigo-600 p-2 rounded-xl">
        <Sparkles className="text-white" size={22} />
      </div>

      <div>
        <h1 className="text-xl font-bold text-gray-800">
          Catch Up
        </h1>

        <p className="text-xs text-gray-500">
          Discover Together
        </p>
      </div>
    </Link>
  );
}

export default Logo;