function CategoryPill({
  label,
  icon,
  active,
  onClick,
}) {
  return (
    <button
      onClick={onClick}
      className={`
        px-5 py-2 rounded-full
        border transition-all duration-200
        font-medium whitespace-nowrap

        ${
          active
            ? "bg-indigo-600 text-white border-indigo-600 shadow-md"
            : "bg-white text-gray-700 border-gray-200 hover:bg-indigo-50 hover:border-indigo-300"
        }
      `}
    >
      <span className="mr-2">{icon}</span>
      {label}
    </button>
  );
}

export default CategoryPill;