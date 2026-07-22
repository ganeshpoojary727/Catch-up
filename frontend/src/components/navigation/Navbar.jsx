import Logo from "./Logo";
import NotificationBell from "./NotificationBell";
import ProfileMenu from "./ProfileMenu";

function Navbar() {
  return (
    <nav className="bg-white border-b border-gray-200 sticky top-0 z-50">
      <div className="max-w-7xl mx-auto px-6 h-20 flex items-center justify-between">

        {/* Left */}
        <Logo />

        {/* Right */}
        <div className="flex items-center gap-4">
          <NotificationBell />
          <ProfileMenu />
        </div>

      </div>
    </nav>
  );
}

export default Navbar;