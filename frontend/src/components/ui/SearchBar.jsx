import { Search } from "lucide-react";

function SearchBar({
  placeholder = "Search events, people, locations...",
  value,
  onChange,
}) {
  return (
    <div className="flex items-center gap-3 bg-white border border-gray-200 rounded-xl px-4 py-3 shadow-sm focus-within:ring-2 focus-within:ring-indigo-500 transition-all">
      <Search size={20} className="text-gray-500" />

      <input
        type="text"
        placeholder={placeholder}
        value={value}
        onChange={onChange}
        className="flex-1 outline-none bg-transparent"
      />
    </div>
  );
}

export default SearchBar;