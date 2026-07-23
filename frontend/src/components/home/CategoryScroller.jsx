import CategoryPill from "../feed/CategoryPill";

const categories = [
  { label: "Trending", icon: "🔥" },
  { label: "Technology", icon: "💻" },
  { label: "Music", icon: "🎵" },
  { label: "Automotive", icon: "🏍️" },
  { label: "Sports", icon: "⚽" },
  { label: "Art", icon: "🎨" },
  { label: "Gaming", icon: "🎮" },
];

function CategoryScroller({
  selectedCategory,
  setSelectedCategory,
}) {
  return (
    <div className="flex gap-3 overflow-x-auto py-3 scrollbar-hide">
      {categories.map((category) => (
        <CategoryPill
          key={category.label}
          label={category.label}
          icon={category.icon}
          active={selectedCategory === category.label}
          onClick={() => setSelectedCategory(category.label)}
        />
      ))}
    </div>
  );
}

export default CategoryScroller;