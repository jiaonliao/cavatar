package io.github.jiaonliao.cavatar.constant;


import java.util.HashMap;
import java.util.Map;

/**
 * @author wren
 */
public interface WidgetConstant {
    Map<BaseWrapperShape, String> ASSET_MAPPING = MapBuilder.builder(new HashMap<BaseWrapperShape, String>())
            .put(Face.BASE, "/avatar/face/base.svg")
            .put(Ear.ATTACHED, "/avatar/ear/attached.svg")
            .put(Ear.DETACHED, "/avatar/ear/detached.svg")
            .put(Eyes.ELLIPSE, "/avatar/eyes/ellipse.svg")
            .put(Eyes.EYESHADOW, "/avatar/eyes/eyeshadow.svg")
            .put(Eyes.ROUND, "/avatar/eyes/round.svg")
            .put(Eyes.SMILING, "/avatar/eyes/smiling.svg")
            .put(Beard.SCRUFF, "/avatar/beard/scruff.svg")
            .put(Clothes.COLLARED, "/avatar/clothes/collared.svg")
            .put(Clothes.CREW, "/avatar/clothes/crew.svg")
            .put(Clothes.OPEN, "/avatar/clothes/open.svg")
            .put(Earrings.HOOP, "/avatar/earrings/hoop.svg")
            .put(Earrings.STUD, "/avatar/earrings/stud.svg")
            .put(Eyebrows.DOWN, "/avatar/eyebrows/down.svg")
            .put(Eyebrows.EYELASHESDOWN, "/avatar/eyebrows/eyelashesdown.svg")
            .put(Eyebrows.EYELASHESUP, "/avatar/eyebrows/eyelashesup.svg")
            .put(Eyebrows.UP, "/avatar/eyebrows/up.svg")
            .put(Glasses.ROUND, "/avatar/glasses/round.svg")
            .put(Glasses.SQUARE, "/avatar/glasses/square.svg")
            .put(Mouth.FROWN, "/avatar/mouth/frown.svg")
            .put(Mouth.LAUGHING, "/avatar/mouth/laughing.svg")
            .put(Mouth.NERVOUS, "/avatar/mouth/nervous.svg")
            .put(Mouth.PUCKER, "/avatar/mouth/pucker.svg")
            .put(Mouth.SAD, "/avatar/mouth/sad.svg")
            .put(Mouth.SMILE, "/avatar/mouth/smile.svg")
            .put(Mouth.SMIRK, "/avatar/mouth/smirk.svg")
            .put(Mouth.SURPRISED, "/avatar/mouth/surprised.svg")
            .put(Nose.CURVE, "/avatar/nose/curve.svg")
            .put(Nose.POINTED, "/avatar/nose/pointed.svg")
            .put(Nose.ROUND, "/avatar/nose/round.svg")
            .put(Tops.BEANIE, "/avatar/tops/beanie.svg")
            .put(Tops.CLEAN, "/avatar/tops/clean.svg")
            .put(Tops.DANNY, "/avatar/tops/danny.svg")
            .put(Tops.FONZE, "/avatar/tops/fonze.svg")
            .put(Tops.FUNNY, "/avatar/tops/funny.svg")
            .put(Tops.PIXIE, "/avatar/tops/pixie.svg")
            .put(Tops.PUNK, "/avatar/tops/punk.svg")
            .put(Tops.TURBAN, "/avatar/tops/turban.svg")
            .put(Tops.WAVE, "/avatar/tops/wave.svg")
            .build();

    /**
     * 脸型枚举
     *
     * @author wren
     */
    enum Face implements BaseWrapperShape {
        /**
         * 基础脸型
         */
        BASE;

        @Override
        public int getLayer() {
            return 10;
        }

    }

    enum Tops implements BaseWrapperShape {

        FONZE,
        FUNNY,
        CLEAN,
        PUNK,
        DANNY,
        WAVE,
        TURBAN,
        PIXIE,
        BEANIE;

        @Override
        public int getLayer() {
            return 80;
        }
    }

    enum Ear implements BaseWrapperShape {
        ATTACHED,
        DETACHED;

        @Override
        public int getLayer() {
            return 102;
        }
    }

    enum Earrings implements BaseWrapperShape {
        HOOP,
        STUD,
        NONE;

        @Override
        public int getLayer() {
            return 103;
        }
    }

    enum Eyebrows implements BaseWrapperShape {
        UP,
        DOWN,
        EYELASHESUP,
        EYELASHESDOWN,
        ;

        @Override
        public int getLayer() {
            return 70;
        }
    }

    enum Eyes implements BaseWrapperShape {
        ELLIPSE,
        SMILING,
        EYESHADOW,
        ROUND,
        ;

        @Override
        public int getLayer() {
            return 50;
        }
    }

    enum Nose implements BaseWrapperShape {
        CURVE,
        ROUND,
        POINTED,
        ;

        @Override
        public int getLayer() {
            return 60;
        }
    }

    enum Mouth implements BaseWrapperShape {
        FROWN,
        LAUGHING,
        NERVOUS,
        PUCKER,
        SAD,
        SMILE,
        SMIRK,
        SURPRISED,
        ;

        @Override
        public int getLayer() {
            return 100;
        }
    }

    enum Beard implements BaseWrapperShape {
        SCRUFF,
        NONE,
        ;

        @Override
        public int getLayer() {
            return 99;
        }
    }

    enum Glasses implements BaseWrapperShape {
        ROUND,
        SQUARE,
        NONE,
        ;

        @Override
        public int getLayer() {
            return 90;
        }
    }

    enum Clothes implements BaseWrapperShape {
        CREW,
        COLLARED,
        OPEN,
        ;

        @Override
        public int getLayer() {
            return 110;
        }
    }

    class MapBuilder<T, V> {
        private final Map<T, V> map;

        public MapBuilder() {
            map = new HashMap<>();
        }

        public MapBuilder<T, V> put(T key, V value) {
            map.put(key, value);
            return this;
        }

        public Map<T, V> build() {
            return map;
        }

        public static <T, V> MapBuilder<T, V> builder(HashMap<T, V> builderMap) {
            return new MapBuilder<T, V>();
        }
    }
}
