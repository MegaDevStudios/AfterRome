package dev.mega.afterrome.config.menu;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter @Setter
@AllArgsConstructor
public class MenuSection {
    private final String name;
    private final UpgradeMenuSection upgradeMenuSection;
    private final ShopMenuSection shopMenuSection;
}
