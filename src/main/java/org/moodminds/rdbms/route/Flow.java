package org.moodminds.rdbms.route;

import org.moodminds.emission.Emittable;
import org.moodminds.emission.Resource;
import org.moodminds.function.*;
import org.moodminds.rdbms.Types;
import org.moodminds.rdbms.clause.Clause;
import org.moodminds.rdbms.clause.Clausing;
import org.moodminds.rdbms.data.Signal;
import org.moodminds.rdbms.data.*;
import org.moodminds.rdbms.data.Tuple;
import org.moodminds.rdbms.data.Tuple1;
import org.moodminds.rdbms.data.Tuple2;
import org.moodminds.rdbms.data.Tuple3;
import org.moodminds.rdbms.data.Tuple4;
import org.moodminds.rdbms.data.Tuple5;
import org.moodminds.rdbms.data.Tuple6;
import org.moodminds.rdbms.data.Tuple7;
import org.moodminds.rdbms.data.Tuple8;
import org.moodminds.rdbms.lang.*;
import org.moodminds.route.*;
import org.moodminds.type.*;

import java.lang.String;
import java.nio.ByteBuffer;
import java.util.Comparator;
import java.util.stream.BaseStream;
import java.util.stream.Collector;

/**
 * The flow definition interface to define RDBMS routes.
 *
 * @param <$F> the type of the flow definition interface
 * @param <$S> the type of the statements definition interface
 * @param <$T> the type of the RDBMS types' accessor interface
 * @param <E>  the type of possible exception
 */
public interface Flow<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, E extends Exception>
        extends org.moodminds.route.Flow<$F, E> {

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @param <H>           {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <H extends Exception> CatchingAction<$F, $S, $T, H, E> refuse(ValueLevel0<? extends Resource<?, ? extends H>> resource);

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @param <H>           {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> refuse(ValueLevel1<? extends Resource<?, ? extends E>> resource);

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @param <H>           {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> refuse(ValueLevel2<? extends Resource<?, ? extends RuntimeException>> resource);

    /**
     * {@inheritDoc}
     *
     * @param {@inheritDoc}
     * @param <H>           {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> refuse(ValueLevel3<? extends Resource<?, E>> resource);

    /**
     * {@inheritDoc}
     *
     * @param execution {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> effect(ExecutableThrowing1<? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Emittable<?, ? extends H>> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Emittable<?, ? extends E>> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Emittable<?, ? extends RuntimeException>> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Emittable<?, E>> route);

    /**
     * {@inheritDoc}
     *
     * @param supplier {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    <V> ExpectingStream<$S, $T, V, E> supply(EvaluableThrowing1<? extends V, ? extends E> supplier);

    /**
     * {@inheritDoc}
     *
     * @param source {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> source(Value<? extends Iterable<V>> source);

    /**
     * {@inheritDoc}
     *
     * @param source {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> source(EvaluableThrowing1<? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(Block<? extends Flowing<?>> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.RouteLevel0<? extends H, ?> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.RouteLevel1<? extends E, ?> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.RouteLevel2<? extends RuntimeException, ?> route);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.RouteLevel3<E, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <H extends Exception> CatchingAction<$F, $S, $T, H, E> action(RouteLevel0<? extends H, ? super $S, ? super $T, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, $S, $T, E> action(RouteLevel1<? extends E, ? super $S, ? super $T, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, $S, $T, E> action(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ?> route);

    /**
     * Add the execution of the specified route to the flow.
     *
     * @param route the specified route definition
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ExpectingAction<$F, $S, $T, E> action(RouteLevel3<E, ? super $S, ? super $T, ?> route);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.RouteLevel0<? extends H, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Emittable<? extends V, ? extends H>> stream);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(RouteLevel0<? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> stream(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> stream(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> stream(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the values defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, $R extends Routing<?>> $R stream(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Block1<? super O, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Emittable<? extends V, ? extends E>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Emittable<? extends V, ? extends RuntimeException>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Emittable<? extends V, E>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts and emits {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> sort(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of sorted {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R sort(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> sort(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> sort(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> sort(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> sort(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that sorts with the given {@link Comparator} and emits values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> sort(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of sorted with the given {@link Comparator} values
     * defined in the specified streaming route.
     *
     * @param stream     the specified streaming route
     * @param comparator the given values {@link Comparator}
     * @param handler    the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R sort(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> unique(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param keySelector {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @param <K>         {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, K> ExpectingStream<$S, $T, V, E> unique(Block<? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param keySelector {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @param <K>         {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, K> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param keySelector {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @param <K>         {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, K> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param keySelector {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @param <K>         {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V, K> ExpectingStream<$S, $T, V, E> unique(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> unique(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<$S, $T, V, E> unique(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> unique(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<$S, $T, V, E> unique(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> unique(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits only uniques of values
     * defined in the specified streaming route, as compared by a value returned with the specified {@link Evaluable1Throwing1}.
     *
     * @param stream      the specified streaming route
     * @param keySelector the specified comparing value function
     * @param <V>         the type of the emitting values
     * @param <K>         the type of value to compare for uniqueness
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, K> ExpectingStream<$S, $T, V, E> unique(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable1Throwing1<? super V, ? extends K, ? extends E> keySelector);


    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param filter {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> filter(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param filter {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> filter(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param filter {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> filter(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param filter {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     * @throws RuntimeException {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> filter(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> filter(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> filter(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined with the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream the specified streaming route
     * @param filter the given {@link Testable1Throwing1} filter
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> filter(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter);

    /**
     * Continue route definition in the given handler of values defined in the specified streaming route
     * and filtered with the given {@link Testable1Throwing1}.
     *
     * @param stream  the specified streaming route
     * @param filter  the given {@link Testable1Throwing1} filter
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R filter(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> filter, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param converter {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> map(Block<? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param converter {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> map(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param converter {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> map(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param converter {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> map(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> map(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> map(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that converts with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> map(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter);

    /**
     * Continue route definition in the given handler of converted with the given {@link Evaluable1Throwing1} values
     * defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param converter the given {@link Evaluable1Throwing1} converter
     * @param handler   the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R map(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable1Throwing1<? super O, ? extends V, ? extends E> converter, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> first(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> first(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> first(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> first(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> first(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> first(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits first of values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting value
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> first(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of first of values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R first(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(long number, Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(long number, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(long number, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(long number, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> take(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);


    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(long number, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(long number, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to emit
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(long number, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler for the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to emit
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(long number, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> take(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler for the values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R take(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(long number, Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(long number, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(long number, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param number {@inheritDoc}
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(long number, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);


    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> skip(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);


    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(long number, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(long number, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skip the given number of values
     * defined in the specified streaming route.
     *
     * @param number the given number of values to skip
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(long number, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the remaining after skipping the given number of values
     * defined in the specified streaming route.
     *
     * @param number  the given number of values to skip
     * @param stream  the specified streaming route
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(long number, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that skips values defined in the specified streaming route
     * while matching the provided {@link Testable1Throwing1} predicate.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param <V>       the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> skip(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the provided handler with the remaining values, skipping those determined
     * by the given {@link Testable1Throwing1} predicate, as defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the provided {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R skip(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> all(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> all(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> all(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> all(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> all(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> all(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> all(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R all(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> any(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> any(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> any(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> any(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> any(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> any(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any of the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> any(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code true}
     * with the given {@link Testable1Throwing1} of any the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R any(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> none(Block<? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> none(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> none(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, Boolean, E> none(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> none(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> none(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param <V>       the type of the source emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, Boolean, E> none(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate);

    /**
     * Continue route definition in the given handler of the boolean result of testing for {@code false}
     * with the given {@link Testable1Throwing1} of all the values defined in the specified streaming route.
     *
     * @param stream    the specified streaming route
     * @param predicate the given values {@link Testable1Throwing1} predicate
     * @param handler   the given values handling route
     * @param <V>       the type of the emitting values
     * @param <$R>      the type of the route definition result
     * @return handling route definition result
     */
    <V, $R extends Routing<?>> $R none(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Testable1Throwing1<? super V, ? extends E> predicate, Block1<? super Boolean, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> min(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the minimum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R min(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> min(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> min(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> min(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> min(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> min(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the minimum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given minimum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R min(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(Block<? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream the specified streaming route
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>> ExpectingStream<$S, $T, V, E> max(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream);

    /**
     * Continue route definition in the given handler of the maximum of the {@link Comparable} values
     * defined in the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V extends Comparable<V>, $R extends Routing<?>> $R max(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> max(Block<? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * {@inheritDoc}
     *
     * @param stream     {@inheritDoc}
     * @param comparator {@inheritDoc}
     * @param <V>        {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> max(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> max(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> max(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param <V>        the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> max(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator);

    /**
     * Continue route definition in the given handler of the maximum of the values
     * defined in the specified streaming route using the specified {@link Comparator}.
     *
     * @param stream     the specified streaming route
     * @param comparator the specified {@link Comparator}
     * @param handler    the given maximum value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R max(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Comparator<? super V> comparator, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> reduce(Block<? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> reduce(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> reduce(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> reduce(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <V>         the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> reduce(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <V>         the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> reduce(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <V>         the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> reduce(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified combination function.
     *
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R reduce(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Evaluable2<? super V, ? super V, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param initial     {@inheritDoc}
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <O>         {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, Block<? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param initial     {@inheritDoc}
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <O>         {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param initial     {@inheritDoc}
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <O>         {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * {@inheritDoc}
     *
     * @param initial     {@inheritDoc}
     * @param stream      {@inheritDoc}
     * @param accumulator {@inheritDoc}
     * @param <O>         {@inheritDoc}
     * @param <V>         {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param <O>         the type of the source emitting values
     * @param <V>         the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> reduce(V initial, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified initial value and the combination function.
     *
     * @param initial     the specified source initial value
     * @param stream      the specified streaming route
     * @param accumulator two values combination function
     * @param handler     the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R reduce(V initial, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Evaluable2<? super V, ? super O, ? extends V> accumulator, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param collector {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> collect(Block<? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param collector {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> collect(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param collector {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> collect(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * {@inheritDoc}
     *
     * @param stream    {@inheritDoc}
     * @param collector {@inheritDoc}
     * @param <O>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <O, V> ExpectingStream<$S, $T, V, E> collect(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> collect(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> collect(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param <O>       the type of the source emitting values
     * @param <V>       the type of the target emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V> ExpectingStream<$S, $T, V, E> collect(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector);

    /**
     * Continue route definition in the given handler of the reduction operation result of the values
     * defined in the specified streaming route using the specified {@link Collector} function.
     *
     * @param stream    the specified streaming route
     * @param collector the specified {@link Collector}
     * @param handler   the given reduction value handling route
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <O, V, $R extends Routing<?>> $R collect(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends O>> stream, Collector<? super O, ?, ? extends V> collector, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(Block<? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * {@inheritDoc}
     *
     * @param stream1 {@inheritDoc}
     * @param stream2 {@inheritDoc}
     * @param <V>     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, Block<? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel1<? extends E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, org.moodminds.route.RouteLevel3<E, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param <V>     the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ExpectingStream<$S, $T, V, E> concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2);

    /**
     * Continue route definition in the given handler of the concatenation result of the values
     * defined in the specified streaming routes.
     *
     * @param stream1 the specified streaming route 1
     * @param stream2 the specified streaming route 2
     * @param handler the given values handling route
     * @param <V>     the type of the emitting values
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <V, $R extends Routing<?>> $R concat(RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream1, RouteLevel3<E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream2, Block1<? super V, ? extends Routing<? extends $R>> handler);


    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(Value<Boolean> predicate, ActionLevel3<E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally values defined in the specified streaming route
     * depending on the specified boolean result flag match.
     *
     * @param predicate the specified boolean result value
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(Value<Boolean> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    ChoosingAction<$F, $S, $T, E> either(TestableThrowing1<? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified {@link Testable1Throwing1} match.
     *
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <V> ChoosingStream<$S, $T, V, E> either(TestableThrowing1<? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I> value, Executable1Throwing1<? super I, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value    {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I>      {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends V, ? extends E> supplier);

    /**
     * {@inheritDoc}
     *
     * @param value  {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I> value, Evaluable1Throwing1<? super I, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route1Level0<? super I, ? extends H, ?> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route1Level1<? super I, ? extends E, ?> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route1Level2<? super I, ? extends RuntimeException, ?> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route1Level3<? super I, E, ?> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @param <H>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @param <H>   the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route1Level0<? super I, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, $S, $T, E> action(Route1Level1<? super I, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, $S, $T, E> action(Route1Level2<? super I, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I> value);

    /**
     * Add the execution of the specified route by the specified argument value to the flow.
     *
     * @param route the specified route definition
     * @param value the specified argument value
     * @param <I>   the type of the argument
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ExpectingAction<$F, $S, $T, E> action(Route1Level3<? super I, E, ? super $S, ? super $T, ?> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param route {@inheritDoc}
     * @param value {@inheritDoc}
     * @param <I>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable1Throwing1<? super I, ? extends Emittable<?, E>, E>> route, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream           {@inheritDoc}
     * @param value            {@inheritDoc}
     * @param <I>              {@inheritDoc}
     * @param <V>              {@inheritDoc}
     * @param <H>{@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route1Level0<? super I, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route1Level1<? super I, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route1Level2<? super I, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route1Level3<? super I, E, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route1Level0<? super I, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<$S, $T, V, E> stream(Route1Level1<? super I, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<$S, $T, V, E> stream(Route1Level2<? super I, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified argument.
     *
     * @param stream the specified streaming route
     * @param value  the specified argument value
     * @param <I>    the type of the argument
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ExpectingStream<$S, $T, V, E> stream(Route1Level3<? super I, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I> value);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value  {@inheritDoc}
     * @param <I>    {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable1Throwing1<? super I, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I> value);


    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I> ChoosingAction<$F, $S, $T, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value     {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I>       {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Executable2Throwing1<? super I1, ? super I2, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified value match using the specified {@link Testable1Throwing1}.
     *
     * @param value     the specified argument value
     * @param predicate the specified {@link Testable1Throwing1}
     * @param route     the specified route definition
     * @param <I>       the type of the argument
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);


    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Evaluable2Throwing1<? super I1, ? super I2, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route2Level0<? super I1, ? super I2, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route2Level1<? super I1, ? super I2, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route2Level3<? super I1, ? super I2, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route2Level0<? super I1, ? super I2, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(Route2Level1<? super I1, ? super I2, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(Route2Level3<? super I1, ? super I2, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route2Level0<? super I1, ? super I2, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route2Level1<? super I1, ? super I2, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route2Level3<? super I1, ? super I2, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route2Level0<? super I1, ? super I2, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(Route2Level1<? super I1, ? super I2, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(Route2Level2<? super I1, ? super I2, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified value 1
     * @param value2 the specified value 2
     * @param <I1>   the type of the route argument 1
     * @param <I2>   the type of the route argument 2
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(Route2Level3<? super I1, ? super I2, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable2Throwing1<? super I1, ? super I2, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Executable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable2}.
     *
     * @param value1    the specified value 1
     * @param value2    the specified value 2
     * @param predicate the specified {@link Testable2}
     * @param route     the specified route definition
     * @param <I1>      the type of the input value 1 to check
     * @param <I2>      the type of the input value 2 to check
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route3Level3<? super I1, ? super I2, ? super I3, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(Route3Level3<? super I1, ? super I2, ? super I3, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route3Level3<? super I1, ? super I2, ? super I3, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route3Level0<? super I1, ? super I2, ? super I3, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(Route3Level1<? super I1, ? super I2, ? super I3, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(Route3Level2<? super I1, ? super I2, ? super I3, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(Route3Level3<? super I1, ? super I2, ? super I3, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable3Throwing1<? super I1, ? super I2, ? super I3, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Executable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param value4   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <I4>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable3}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param predicate the specified {@link Testable3}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route4Level0<? super I1, ? super I2, ? super I3, ? super I4, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(Route4Level1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(Route4Level2<? super I1, ? super I2, ? super I3, ? super I4, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(Route4Level3<? super I1, ? super I2, ? super I3, ? super I4, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Executable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param value4   {@inheritDoc}
     * @param value5   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <I4>     {@inheritDoc}
     * @param <I5>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable4}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param predicate the specified {@link Testable4}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route5Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(Route5Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(Route5Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(Route5Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Executable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param value4   {@inheritDoc}
     * @param value5   {@inheritDoc}
     * @param value6   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <I4>     {@inheritDoc}
     * @param <I5>     {@inheritDoc}
     * @param <I6>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable5}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param predicate the specified {@link Testable5}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route6Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(Route6Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(Route6Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(Route6Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Executable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param value4   {@inheritDoc}
     * @param value5   {@inheritDoc}
     * @param value6   {@inheritDoc}
     * @param value7   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <I4>     {@inheritDoc}
     * @param <I5>     {@inheritDoc}
     * @param <I6>     {@inheritDoc}
     * @param <I7>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable6}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param predicate the specified {@link Testable6}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route7Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(Route7Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(Route7Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(Route7Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param execution {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> effect(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Executable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> execution);

    /**
     * {@inheritDoc}
     *
     * @param value1   {@inheritDoc}
     * @param value2   {@inheritDoc}
     * @param value3   {@inheritDoc}
     * @param value4   {@inheritDoc}
     * @param value5   {@inheritDoc}
     * @param value6   {@inheritDoc}
     * @param value7   {@inheritDoc}
     * @param value8   {@inheritDoc}
     * @param supplier {@inheritDoc}
     * @param <I1>     {@inheritDoc}
     * @param <I2>     {@inheritDoc}
     * @param <I3>     {@inheritDoc}
     * @param <I4>     {@inheritDoc}
     * @param <I5>     {@inheritDoc}
     * @param <I6>     {@inheritDoc}
     * @param <I7>     {@inheritDoc}
     * @param <I8>     {@inheritDoc}
     * @param <V>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> supply(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends V, ? extends E> supplier);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable7}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param predicate the specified {@link Testable7}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param source {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> source(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends BaseStream<V, ?>, ? extends E> source);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(org.moodminds.route.Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(org.moodminds.route.Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(ValueLevel0<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends H>, ? extends H>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, H extends Exception> CatchingAction<$F, $S, $T, H, E> action(Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Add the execution of the specified route by the specified argument values to the flow.
     *
     * @param route  the specified route definition
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @return the action attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ? super $S, ? super $T, ?> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(ValueLevel1<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends E>, ? extends E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(ValueLevel2<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, ? extends RuntimeException>, ? extends RuntimeException>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param route  {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ExpectingAction<$F, $S, $T, E> action(ValueLevel3<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<?, E>, E>> route, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(org.moodminds.route.Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(org.moodminds.route.Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @param <H>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(ValueLevel0<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends H>, ? extends H>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @param <H>    the type of unexpected exception that might be thrown
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V, H extends Exception> CatchingStream<$S, $T, V, H, E> stream(Route8Level0<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends H, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(Route8Level1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);


    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(Route8Level2<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends RuntimeException, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * Complete route definition as such that emits values defined
     * in the specified streaming route by the specified arguments.
     *
     * @param stream the specified streaming route
     * @param value1 the specified argument value 1
     * @param value2 the specified argument value 2
     * @param value3 the specified argument value 3
     * @param value4 the specified argument value 4
     * @param value5 the specified argument value 5
     * @param value6 the specified argument value 6
     * @param value7 the specified argument value 7
     * @param value8 the specified argument value 8
     * @param <I1>   the type of argument 1
     * @param <I2>   the type of argument 2
     * @param <I3>   the type of argument 3
     * @param <I4>   the type of argument 4
     * @param <I5>   the type of argument 5
     * @param <I6>   the type of argument 6
     * @param <I7>   the type of argument 7
     * @param <I8>   the type of argument 8
     * @param <V>    the type of the emitting values
     * @return the emitting attempt definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(Route8Level3<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, E, ? super $S, ? super $T, ? extends Emitting<? extends V>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel1<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends E>, ? extends E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel2<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, ? extends RuntimeException>, ? extends RuntimeException>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);

    /**
     * {@inheritDoc}
     *
     * @param stream {@inheritDoc}
     * @param value1 {@inheritDoc}
     * @param value2 {@inheritDoc}
     * @param value3 {@inheritDoc}
     * @param value4 {@inheritDoc}
     * @param value5 {@inheritDoc}
     * @param value6 {@inheritDoc}
     * @param value7 {@inheritDoc}
     * @param value8 {@inheritDoc}
     * @param <I1>   {@inheritDoc}
     * @param <I2>   {@inheritDoc}
     * @param <I3>   {@inheritDoc}
     * @param <I4>   {@inheritDoc}
     * @param <I5>   {@inheritDoc}
     * @param <I6>   {@inheritDoc}
     * @param <I7>   {@inheritDoc}
     * @param <I8>   {@inheritDoc}
     * @param <V>    {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ExpectingStream<$S, $T, V, E> stream(ValueLevel3<? extends Evaluable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends Emittable<? extends V, E>, E>> stream, Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8);


    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionBlock route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.ActionLevel1<? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.ActionLevel2<? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.ActionLevel3<E> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel1<? extends E, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel2<? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Add optionally the execution of the specified route to the flow
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @return the action choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8> ChoosingAction<$F, $S, $T, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, ActionLevel3<E, ? super $S, ? super $T> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamBlock<V> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.StreamLevel1<V, ? extends E> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.StreamLevel2<V, ? extends RuntimeException> route);

    /**
     * {@inheritDoc}
     *
     * @param value1    {@inheritDoc}
     * @param value2    {@inheritDoc}
     * @param value3    {@inheritDoc}
     * @param value4    {@inheritDoc}
     * @param value5    {@inheritDoc}
     * @param value6    {@inheritDoc}
     * @param value7    {@inheritDoc}
     * @param value8    {@inheritDoc}
     * @param predicate {@inheritDoc}
     * @param route     {@inheritDoc}
     * @param <I1>      {@inheritDoc}
     * @param <I2>      {@inheritDoc}
     * @param <I3>      {@inheritDoc}
     * @param <I4>      {@inheritDoc}
     * @param <I5>      {@inheritDoc}
     * @param <I6>      {@inheritDoc}
     * @param <I7>      {@inheritDoc}
     * @param <I8>      {@inheritDoc}
     * @param <V>       {@inheritDoc}
     * @return {@inheritDoc}
     */
    @Override
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.StreamLevel3<V, E> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel1<V, ? extends E, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel2<V, ? extends RuntimeException, ? super $S, ? super $T> route);

    /**
     * Complete route definition as such that emits optionally value defined in the specified streaming route
     * depending on the specified values match using the specified {@link Testable8}.
     *
     * @param value1    the specified argument value 1
     * @param value2    the specified argument value 2
     * @param value3    the specified argument value 3
     * @param value4    the specified argument value 4
     * @param value5    the specified argument value 5
     * @param value6    the specified argument value 6
     * @param value7    the specified argument value 7
     * @param value8    the specified argument value 8
     * @param predicate the specified {@link Testable8}
     * @param route     the specified route definition
     * @param <I1>      the type of argument 1
     * @param <I2>      the type of argument 2
     * @param <I3>      the type of argument 3
     * @param <I4>      the type of argument 4
     * @param <I5>      the type of argument 5
     * @param <I6>      the type of argument 6
     * @param <I7>      the type of argument 7
     * @param <I8>      the type of argument 8
     * @param <V>       the type of the emitting values
     * @return the streaming choice definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    <I1, I2, I3, I4, I5, I6, I7, I8, V> ChoosingStream<$S, $T, V, E> either(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, StreamLevel3<V, E, ? super $S, ? super $T> route);


    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(Block<? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(Block<? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Blarge> blarge(RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream);

    /**
     * Continue route definition in the given handler of a binary large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a binary large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R blarge(RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends ByteBuffer>>> stream, Block1<? super Blarge, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(Block<? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(Block<? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);


    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);

    /**
     * Complete route definition as such that emits a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream the specified streaming route
     * @return emitting result definition object
     * @throws RuntimeException an exception in case of route definition error
     */
    Emitting<Clarge> clarge(RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream);

    /**
     * Continue route definition in the given handler of a character large object value
     * constructed from the specified streaming route.
     *
     * @param stream  the specified streaming route
     * @param handler the given handler of a character large object
     * @param <$R>    the type of the route definition result
     * @return handling route definition result
     * @throws RuntimeException an exception in case of route definition error
     */
    <$R extends Routing<?>> $R clarge(RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends Emitting<? extends CharSequence>>> stream, Block1<? super Clarge, ? extends Routing<? extends $R>> handler);


    /**
     * Define execution of the RDBMS statement by the given {@link Clause} script.
     *
     * @param script the given {@link Clause} script
     * @return RDBMS statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    Effecting<$F, $S, $T, E> effect(Clause<? super $S, ? super $T, ? extends Clausing<? extends Statement>> script);

    /**
     * Define execution of the RDBMS affecting statement (INSERT/DELETE/UPDATE) by the given {@link Clause} script.
     *
     * @param script the given {@link Clause} script
     * @return RDBMS affecting statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    Affecting<$F, $S, $T, E> affect(Clause<? super $S, ? super $T, ? extends Clausing<? extends Affect>> script);

    /**
     * Define execution of the RDBMS affecting statement (INSERT/DELETE/UPDATE) by the given {@link Clause} script
     * and return execution definition object that defines emission of the updated rows number.
     *
     * @param script the given {@link Clause} script
     * @return RDBMS affecting statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    Updating update(Clause<? super $S, ? super $T, ? extends Clausing<? extends Affect>> script);

    /**
     * Define execution of the RDBMS creating statement by the given {@link Clause} script and return
     * execution definition object that defines emission of the created rows generated keys {@link Relation}.
     *
     * @param script the given {@link Clause} script
     * @return RDBMS creating statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    Creating create(Clause<? super $S, ? super $T, ? extends Clausing<? extends Create>> script);

    /**
     * Define execution of the RDBMS querying statement by the given {@link Clause} script and return
     * execution definition object that defines emission of the updated rows number {@link Relation}.
     *
     * @param script the given {@link Clause} script
     * @param <R>    the type of the emitting relation
     * @param <X>    the type of the emitting relation tuple
     * @return RDBMS querying statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    <R extends Relation<? extends X>, X extends Tuple> Relating<X, R> relate(Clause<? super $S, ? super $T, ? extends Clausing<? extends Query<? extends R>>> script);

    /**
     * Define execution of the RDBMS stored procedure by the given calling statement {@link Clause} script.
     *
     * @param clause the given {@link Clause} script
     * @return RDBMS stored procedure calling statement execution definition object
     * @throws RuntimeException - an exception in case of route definition error
     */
    Invoking invoke(Clause<? super $S, ? super $T, ? extends Clausing<? extends Call>> clause);


    /**
     * A streaming result following execution definition.
     *
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <V>  the type of the emitting values
     * @param <E>  the type of possible exception that might be thrown
     */
    interface Following<$S, $T extends Types, V, E extends Exception> extends org.moodminds.route.Flow.Following<V, E> {

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel1<? extends E, ? super $S, ? super $T, ?> route);

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ?> route);

        /**
         * Add the execution of the specified route after the streaming completion.
         *
         * @param route the specified route to execute after the streaming completion
         * @return the streaming result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<V> follow(RouteLevel3<E, ? super $S, ? super $T, ?> route);
    }

    /**
     * Throwing expected exception route attempt definition object.
     *
     * @param <$A>  the type of the route attempt definition object
     * @param <$AE> the type of the route attempt definition object extension
     * @param <$S>  the type of the statements definition interface
     * @param <$T>  the type of the RDBMS types' accessor interface
     * @param <$R>  the type of the route definition result
     * @param <E>   the type of possible exception
     */
    interface Expecting<$AE extends $A, $A extends org.moodminds.route.Flow.Expecting<$A, $R, E>, $S, $T extends Types, $R extends Routing<?>, E extends Exception>
            extends org.moodminds.route.Flow.Expecting<$A, $R, E> {

        /**
         * {@inheritDoc}
         *
         * @param retries {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE repair(long retries);

        /**
         * {@inheritDoc}
         *
         * @param type  {@inheritDoc}
         * @param route {@inheritDoc}
         * @param <C>   {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(Class<? extends Throwable> type, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param type  {@inheritDoc}
         * @param route {@inheritDoc}
         * @param <C>   {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <C extends Throwable> $AE caught(Class<? extends C> type, Block1<? super C, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param type  {@inheritDoc}
         * @param route {@inheritDoc}
         * @param <C>   {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <C extends Throwable> $AE caught(Class<? extends C> type, org.moodminds.route.Route1Level1<? super C, ? extends E, ? extends $R> route);

        /**
         * {@inheritDoc}
         *
         * @param type  {@inheritDoc}
         * @param route {@inheritDoc}
         * @param <C>   {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <C extends Throwable> $AE caught(Class<? extends C> type, org.moodminds.route.Route1Level2<? super C, ? extends RuntimeException, ? extends $R> route);

        /**
         * {@inheritDoc}
         *
         * @param type  {@inheritDoc}
         * @param route {@inheritDoc}
         * @param <C>   {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <C extends Throwable> $AE caught(Class<? extends C> type, org.moodminds.route.Route1Level3<? super C, E, ? extends $R> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $AE caught(Class<? extends C> type, Route1Level1<? super C, ? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $AE caught(Class<? extends C> type, Route1Level2<? super C, ? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for exceptions of the specified type.
         *
         * @param type  the specified exception type
         * @param route the specified exception handling route
         * @param <C>   the type of the exception to handle
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <C extends Throwable> $AE caught(Class<? extends C> type, Route1Level3<? super C, E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);
    }

    /**
     * Throwing expected exception action attempt definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <E>  the type of possible exception
     */
    interface ExpectingAction<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, E extends Exception>
            extends org.moodminds.route.Flow.ExpectingAction<$F, E>,
            Expecting<ExpectingAction<$F, $S, $T, E>, org.moodminds.route.Flow.ExpectingAction<$F, E>, $S, $T, Flowing<?>, E>, Flow<$F, $S, $T, E> {
    }

    /**
     * Throwing expected exception stream attempt definition object.
     *
     * @param <V>  the type of the emitting values
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <E>  the type of possible exception that might be thrown
     */
    interface ExpectingStream<$S, $T extends Types, V, E extends Exception>
            extends org.moodminds.route.Flow.ExpectingStream<V, E>,
            Expecting<ExpectingStream<$S, $T, V, E>, org.moodminds.route.Flow.ExpectingStream<V, E>, $S, $T, Emitting<? extends V>, E>, Following<$S, $T, V, E> {
    }


    /**
     * Throwing unexpected exception route attempt definition object.
     *
     * @param <$AE> the type of the route attempt definition object extension
     * @param <$A>  the type of the throwing expected exception attempt definition object
     * @param <$S>  the type of the statements definition interface
     * @param <$T>  the type of the RDBMS types' accessor interface
     * @param <$R>  the type of the route definition result
     * @param <H>   the type of possible unexpected exception that might be thrown
     * @param <E>   the type of possible expected exception that might be thrown
     */
    interface Catching<$AE extends $A, $A extends org.moodminds.route.Flow.Expecting<$A, $R, E>, $S, $T extends Types, $R extends Routing<?>, H extends Exception, E extends Exception>
            extends org.moodminds.route.Flow.Catching<$A, $R, H, E> {

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(Block1<? super H, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(org.moodminds.route.Route1Level1<? super H, ? extends E, ? extends $R> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(org.moodminds.route.Route1Level2<? super H, ? extends RuntimeException, ? extends $R> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $AE caught(org.moodminds.route.Route1Level3<? super H, E, ? extends $R> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $AE caught(Route1Level1<? super H, ? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $AE caught(Route1Level2<? super H, ? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Define the specified handling route for caught exception.
         *
         * @param route the specified exception handling route
         * @return attempt definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $AE caught(Route1Level3<? super H, E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);
    }

    /**
     * Throwing unexpected exception action attempt definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <H>  the type of possible unexpected exception that might be thrown
     * @param <E>  the type of possible expected exception that might be thrown
     */
    interface CatchingAction<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, H extends Exception, E extends Exception>
            extends org.moodminds.route.Flow.CatchingAction<$F, H, E>,
            Catching<ExpectingAction<$F, $S, $T, E>, org.moodminds.route.Flow.ExpectingAction<$F, E>, $S, $T, Flowing<?>, H, E> {
    }

    /**
     * Throwing unexpected exception stream attempt definition object.
     *
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <V>  the type of the emitting values
     * @param <H>  the type of possible unexpected exception that might be thrown
     * @param <E>  the type of possible expected exception that might be thrown
     */
    interface CatchingStream<$S, $T extends Types, V, H extends Exception, E extends Exception>
            extends org.moodminds.route.Flow.CatchingStream<V, H, E>,
            Catching<ExpectingStream<$S, $T, V, E>, org.moodminds.route.Flow.ExpectingStream<V, E>, $S, $T, Emitting<? extends V>, H, E> {
    }

    /**
     * Route conditional definition object.
     *
     * @param <$C>  the type of the route conditional definition object
     * @param <$EC> the type of the route conditional definition object extension
     * @param <$S>  the type of the statements definition interface
     * @param <$T>  the type of the RDBMS types' accessor interface
     * @param <$E>  the type of the conditional route definition result
     * @param <$R>  the type of the route definition result
     * @param <E>   the type of possible exception
     */
    interface Choosing<$EC extends $C, $C extends org.moodminds.route.Flow.Choosing<$C, $E, $R, E>, $S, $T extends Types, $EE extends $E, $E extends Routing<?>, $R extends Routing<?>, E extends Exception>
            extends org.moodminds.route.Flow.Choosing<$C, $E, $R, E> {

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EE option(Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EE option(org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EE option(org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param route {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EE option(org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $EE option(RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $EE option(RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Complete conditional definition specifying the route to execute if no previous cases' conditions match.
         *
         * @param route the specified route definition
         * @return the conditional route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        $EE option(RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(Value<Boolean> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(Value<Boolean> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(Value<Boolean> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(Value<Boolean> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(Value<Boolean> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(Value<Boolean> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified boolean result flag match.
         *
         * @param predicate the specified boolean result value
         * @param route     the specified conditional route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(Value<Boolean> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(TestableThrowing1<? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(TestableThrowing1<? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(TestableThrowing1<? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        $EC option(TestableThrowing1<? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable1Throwing1} match.
         *
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(TestableThrowing1<? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable1Throwing1} match.
         *
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(TestableThrowing1<? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified {@link Testable1Throwing1} match.
         *
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $EC option(TestableThrowing1<? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value     {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I>       {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value     {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I>       {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value     {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I>       {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value     {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I>       {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable1Throwing1}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable1Throwing1}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * value match using the specified {@link Testable1Throwing1}.
         *
         * @param value     the specified value
         * @param predicate the specified {@link Testable1Throwing1}
         * @param route     the specified route definition
         * @param <I>       the type of the argument
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I> $EC option(Value<? extends I> value, Testable1Throwing1<? super I, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable2}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param predicate the specified {@link Testable2}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Testable2Throwing1<? super I1, ? super I2, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);


        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable3}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param predicate the specified {@link Testable3}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Testable3Throwing1<? super I1, ? super I2, ? super I3, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         */
        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         */
        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         */
        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         */
        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable4}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param predicate the specified {@link Testable4}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Testable4Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable5}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param predicate the specified {@link Testable5}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Testable5Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable6}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param predicate the specified {@link Testable6}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Testable6Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable7}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param predicate the specified {@link Testable7}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Testable7Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param value8    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @param <I8>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, Block<? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param value8    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @param <I8>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.RouteLevel1<? extends E, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param value8    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @param <I8>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.RouteLevel2<? extends RuntimeException, ? extends Routing<? extends $R>> route);

        /**
         * {@inheritDoc}
         *
         * @param value1    {@inheritDoc}
         * @param value2    {@inheritDoc}
         * @param value3    {@inheritDoc}
         * @param value4    {@inheritDoc}
         * @param value5    {@inheritDoc}
         * @param value6    {@inheritDoc}
         * @param value7    {@inheritDoc}
         * @param value8    {@inheritDoc}
         * @param predicate {@inheritDoc}
         * @param route     {@inheritDoc}
         * @param <I1>      {@inheritDoc}
         * @param <I2>      {@inheritDoc}
         * @param <I3>      {@inheritDoc}
         * @param <I4>      {@inheritDoc}
         * @param <I5>      {@inheritDoc}
         * @param <I6>      {@inheritDoc}
         * @param <I7>      {@inheritDoc}
         * @param <I8>      {@inheritDoc}
         * @return {@inheritDoc}
         */
        @Override
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, org.moodminds.route.RouteLevel3<E, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel1<? extends E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel2<? extends RuntimeException, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);

        /**
         * Add the specified route conditional execution depending on the specified
         * values match using the specified {@link Testable8}.
         *
         * @param value1    the specified argument value 1
         * @param value2    the specified argument value 2
         * @param value3    the specified argument value 3
         * @param value4    the specified argument value 4
         * @param value5    the specified argument value 5
         * @param value6    the specified argument value 6
         * @param value7    the specified argument value 7
         * @param value8    the specified argument value 8
         * @param predicate the specified {@link Testable8}
         * @param route     the specified route definition
         * @param <I1>      the type of argument 1
         * @param <I2>      the type of argument 2
         * @param <I3>      the type of argument 3
         * @param <I4>      the type of argument 4
         * @param <I5>      the type of argument 5
         * @param <I6>      the type of argument 6
         * @param <I7>      the type of argument 7
         * @param <I8>      the type of argument 8
         * @return conditional route definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <I1, I2, I3, I4, I5, I6, I7, I8> $EC option(Value<? extends I1> value1, Value<? extends I2> value2, Value<? extends I3> value3, Value<? extends I4> value4, Value<? extends I5> value5, Value<? extends I6> value6, Value<? extends I7> value7, Value<? extends I8> value8, Testable8Throwing1<? super I1, ? super I2, ? super I3, ? super I4, ? super I5, ? super I6, ? super I7, ? super I8, ? extends E> predicate, RouteLevel3<E, ? super $S, ? super $T, ? extends Routing<? extends $R>> route);
    }

    /**
     * Action choice definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <E>  the type of possible exception
     */
    interface ChoosingAction<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, E extends Exception>
            extends org.moodminds.route.Flow.ChoosingAction<$F, E>, Choosing<ChoosingAction<$F, $S, $T, E>,
            org.moodminds.route.Flow.ChoosingAction<$F, E>, $S, $T, Flow<$F, $S, $T, E>, org.moodminds.route.Flow<$F, E>, Flowing<?>, E>, Flow<$F, $S, $T, E> {
    }

    /**
     * Stream choice definition object.
     *
     * @param <$S> the type of the statements definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <V>  the type of the emitting values
     * @param <E>  the type of possible exception that might be thrown
     */
    interface ChoosingStream<$S, $T extends Types, V, E extends Exception>
            extends org.moodminds.route.Flow.ChoosingStream<V, E>, Choosing<ChoosingStream<$S, $T, V, E>,
            org.moodminds.route.Flow.ChoosingStream<V, E>, $S, $T, Emitting<V>, Emitting<V>, Emitting<? extends V>, E> {
    }

    /**
     * RDBMS operation definition object.
     *
     * @param <$P> the type of the RDBMS operation definition object
     */
    interface Performing<$P extends Performing<$P>> {

        /**
         * Bind the value as the operation input by the given name
         * and the specified definition object.
         *
         * @param name  the given input name
         * @param value the specified value definition object
         * @return operation definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $P input(String name, Value<?> value);

        /**
         * Complete route definition as such that emits returning statement execution
         * result objects (relation, scalar, warning, exception, message and so on).
         *
         * @return emitting results definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<?> reveal();

        /**
         * Continue route definition in the given handler of the returning statement execution
         * result objects (relation, scalar, warning, exception, message and so on).
         *
         * @param handler the given rdbms statement execution result object handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R reveal(Block1<? super Object, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits returning statement execution
         * result signals - warnings, messages or exceptions.
         *
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<Signal> signal();

        /**
         * Complete route definition as such that emits returning statement execution
         * result signal - warning, message or exception by the given index.
         *
         * @param signal the given signal index
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<Signal> signal(int signal);

        /**
         * Continue route definition in the given handler of the returning statement
         * execution result signals - warnings, messages and exceptions.
         *
         * @param handler the given rdbms statement execution events handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R signal(Block1<? super Signal, ? extends Routing<? extends $R>> handler);


        /**
         * Continue route definition in the given handler of the returning statement
         * execution result signal - warning, message or exception by the given index.
         *
         * @param signal  the given signal index
         * @param handler the given rdbms statement execution events handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R signal(int signal, Block1<? super Signal, ? extends Routing<? extends $R>> handler);
    }

    /**
     * RDBMS batching operation definition object.
     *
     * @param <$P> the type of the RDBMS operation definition object
     */
    interface Batching<$P extends Batching<$P>> extends Performing<$P> {

        /**
         * Define the specified batch size for the operation.
         *
         * @param batch the specified batch size
         * @return flow definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $P batch(int batch);
    }

    /**
     * RDBMS fetching operation definition object.
     *
     * @param <$P> the type of the RDBMS operation definition object
     */
    interface Fetching<$P extends Fetching<$P>> extends Performing<$P> {

        /**
         * Define the specified fetch size for the operation.
         *
         * @param fetch the specified fetch size
         * @return operation definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        $P fetch(int fetch);
    }

    /**
     * Regular RDBMS execution definition object.
     *
     * @param <$F> the type of the flow definition interface
     * @param <$S> the type of the statement definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <E>  the type of possible exception that might be thrown
     */
    interface Effecting<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, E extends Exception>
            extends Performing<Effecting<$F, $S, $T, E>>, Flow<$F, $S, $T, E> {
    }

    /**
     * Regular RDBMS execution definition object that supports batching.
     *
     * @param <$F> the type of the flow definition interface
     * @param <$S> the type of the statement definition interface
     * @param <$T> the type of the RDBMS types' accessor interface
     * @param <E>  the type of possible exception that might be thrown
     */
    interface Affecting<$F extends Flow<?, $S, $T, E>, $S, $T extends Types, E extends Exception>
            extends Batching<Affecting<$F, $S, $T, E>>, Flow<$F, $S, $T, E> {
    }

    /**
     * RDBMS execution definition object that defines emission of the updated rows number.
     */
    interface Updating extends Batching<Updating>, Emitting<Long> {

        /**
         * Continue route definition in the given handler of the updated rows' number.
         *
         * @param handler the given updated rows number handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R number(Block1<? super Long, ? extends Routing<? extends $R>> handler);
    }

    /**
     * RDBMS execution definition object that defines emission of the created rows' generated keys {@link Tuple}.
     */
    interface Creating extends Batching<Creating>, Fetching<Creating>, Emitting<Tuple> {

        /**
         * Continue route definition in the given handler of the created
         * rows' generated keys relation result.
         *
         * @param handler the given created rows' generated keys relation result handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R result(Block1<? super Relation<?>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' generated keys tuples.
         *
         * @param handler the given created rows' generated keys tuples handling route
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R handle(Block1<? super Tuple, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 1-column relation result of generated keys.
         *
         * @param <V> the type of the column 1 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Tuple1<V>> relate1();

        /**
         * Complete route definition as such that emits created rows'
         * 1-column generated keys relation result by the given column name.
         *
         * @param column the given generated keys column name
         * @param <V>    the type of the column 1 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Relation<Tuple1<V>>> result(String column);

        /**
         * Complete route definition as such that emits created rows'
         * 1-column generated keys relation result by the given column type definition object.
         *
         * @param type the given generated keys column type definition object
         * @param <V>  the type of the column 1 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Relation<Tuple1<V>>> result(Type1<V> type);


        /**
         * Complete route definition as such that emits created rows'
         * 1-column generated keys relation result by the given column name and type definition object.
         *
         * @param column the given generated keys column name
         * @param type   the given generated keys column type definition object
         * @param <V>    the type of the column 1 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Relation<Tuple1<V>>> result(String column, Type1<V> type);


        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys relation result by the given column name.
         *
         * @param column  the given generated keys column name
         * @param handler the given created rows' 1-column generated keys relation result handling route
         * @param <V>     the type of the column 1 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R result(String column, Block1<? super Relation<Tuple1<V>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys tuples by the given column name.
         *
         * @param column  the given generated keys column name
         * @param handler the given created rows' 1-column generated keys tuples handling route
         * @param <V>     the type of the column 1 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R handle(String column, Block1<? super Tuple1<V>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys relation result by the given column type definition object.
         *
         * @param type    the given generated keys column type definition object
         * @param handler the given created rows' 1-column generated keys relation result handling route
         * @param <V>     the type of the column 1 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R result(Type1<V> type, Block1<? super Relation<Tuple1<V>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys tuples by the given column type definition object.
         *
         * @param type    the given generated keys column type definition object
         * @param handler the given created rows' 1-column generated keys tuples handling route
         * @param <V>     the type of the column 1 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R handle(Type1<V> type, Block1<? super Tuple1<V>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys relation result by the given column name and type definition object.
         *
         * @param column  the given generated keys column name
         * @param type    the given generated keys column type definition object
         * @param handler the given created rows' 1-column generated keys relation result handling route
         * @param <V>     the type of the column 1 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R result(String column, Type1<V> type, Block1<? super Relation<Tuple1<V>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created
         * rows' 1-column generated keys tuples by the given column name and type definition object.
         *
         * @param column  the given generated keys column name
         * @param type    the given generated keys column type definition object
         * @param handler the given created rows' 1-column generated keys tuples handling route
         * @param <V>     the type of the column 1 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R handle(String column, Type1<V> type, Block1<? super Tuple1<V>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 2-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuples
         * @param <V2> the type of the column 2 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Tuple2<V1, V2>> relate2();

        /**
         * Complete route definition as such that emits created rows'
         * 2-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Relation<Tuple2<V1, V2>>> result(String column1, String column2);

        /**
         * Complete route definition as such that emits created rows'
         * 2-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuples
         * @param <V2> the type of the column 2 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Relation<Tuple2<V1, V2>>> result(Type2<V1, V2> type);

        /**
         * Complete route definition as such that emits created rows'
         * 2-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Relation<Tuple2<V1, V2>>> result(String column1, String column2, Type2<V1, V2> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param handler the given created rows' 2-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R result(String column1, String column2, Block1<? super Relation<Tuple2<V1, V2>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param handler the given created rows' 2-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R handle(String column1, String column2, Block1<? super Tuple2<V1, V2>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 2-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R result(Type2<V1, V2> type, Block1<? super Relation<Tuple2<V1, V2>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 2-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R handle(Type2<V1, V2> type, Block1<? super Tuple2<V1, V2>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 2-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R result(String column1, String column2, Type2<V1, V2> type, Block1<? super Relation<Tuple2<V1, V2>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 2-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 2-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuples
         * @param <V2>    the type of the column 2 of the generated keys tuples
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R handle(String column1, String column2, Type2<V1, V2> type, Block1<? super Tuple2<V1, V2>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 3-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Tuple3<V1, V2, V3>> relate3();

        /**
         * Complete route definition as such that emits created rows'
         * 3-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Relation<Tuple3<V1, V2, V3>>> result(String column1, String column2, String column3);

        /**
         * Complete route definition as such that emits created rows'
         * 3-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Relation<Tuple3<V1, V2, V3>>> result(Type3<V1, V2, V3> type);

        /**
         * Complete route definition as such that emits created rows'
         * 3-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Relation<Tuple3<V1, V2, V3>>> result(String column1, String column2, String column3, Type3<V1, V2, V3> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param handler the given created rows' 3-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R result(String column1, String column2, String column3, Block1<? super Relation<Tuple3<V1, V2, V3>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param handler the given created rows' 3-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R handle(String column1, String column2, String column3, Block1<? super Tuple3<V1, V2, V3>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 3-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R result(Type3<V1, V2, V3> type, Block1<? super Relation<Tuple3<V1, V2, V3>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 3-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R handle(Type3<V1, V2, V3> type, Block1<? super Tuple3<V1, V2, V3>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 3-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R result(String column1, String column2, String column3, Type3<V1, V2, V3> type, Block1<? super Relation<Tuple3<V1, V2, V3>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 3-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 3-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R handle(String column1, String column2, String column3, Type3<V1, V2, V3> type, Block1<? super Tuple3<V1, V2, V3>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 4-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Tuple4<V1, V2, V3, V4>> relate4();

        /**
         * Complete route definition as such that emits created rows'
         * 4-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Relation<Tuple4<V1, V2, V3, V4>>> result(String column1, String column2, String column3, String column4);

        /**
         * Complete route definition as such that emits created rows'
         * 4-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Relation<Tuple4<V1, V2, V3, V4>>> result(Type4<V1, V2, V3, V4> type);

        /**
         * Complete route definition as such that emits created rows'
         * 4-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Relation<Tuple4<V1, V2, V3, V4>>> result(String column1, String column2, String column3, String column4, Type4<V1, V2, V3, V4> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param handler the given created rows' 4-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, Block1<? super Relation<Tuple4<V1, V2, V3, V4>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param handler the given created rows' 4-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, Block1<? super Tuple4<V1, V2, V3, V4>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 4-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R result(Type4<V1, V2, V3, V4> type, Block1<? super Relation<Tuple4<V1, V2, V3, V4>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 4-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R handle(Type4<V1, V2, V3, V4> type, Block1<? super Tuple4<V1, V2, V3, V4>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 4-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, Type4<V1, V2, V3, V4> type, Block1<? super Relation<Tuple4<V1, V2, V3, V4>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 4-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 4-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, Type4<V1, V2, V3, V4> type, Block1<? super Tuple4<V1, V2, V3, V4>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 5-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Tuple5<V1, V2, V3, V4, V5>> relate5();

        /**
         * Complete route definition as such that emits created rows'
         * 5-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Relation<Tuple5<V1, V2, V3, V4, V5>>> result(String column1, String column2, String column3, String column4, String column5);

        /**
         * Complete route definition as such that emits created rows'
         * 5-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Relation<Tuple5<V1, V2, V3, V4, V5>>> result(Type5<V1, V2, V3, V4, V5> type);

        /**
         * Complete route definition as such that emits created rows'
         * 5-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Relation<Tuple5<V1, V2, V3, V4, V5>>> result(String column1, String column2, String column3, String column4, String column5, Type5<V1, V2, V3, V4, V5> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param handler the given created rows' 5-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, Block1<? super Relation<Tuple5<V1, V2, V3, V4, V5>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param handler the given created rows' 5-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, Block1<? super Tuple5<V1, V2, V3, V4, V5>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 5-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R result(Type5<V1, V2, V3, V4, V5> type, Block1<? super Relation<Tuple5<V1, V2, V3, V4, V5>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 5-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R handle(Type5<V1, V2, V3, V4, V5> type, Block1<? super Tuple5<V1, V2, V3, V4, V5>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 5-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, Type5<V1, V2, V3, V4, V5> type, Block1<? super Relation<Tuple5<V1, V2, V3, V4, V5>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 5-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 5-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, Type5<V1, V2, V3, V4, V5> type, Block1<? super Tuple5<V1, V2, V3, V4, V5>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 6-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Tuple6<V1, V2, V3, V4, V5, V6>> relate6();

        /**
         * Complete route definition as such that emits created rows'
         * 6-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Relation<Tuple6<V1, V2, V3, V4, V5, V6>>> result(String column1, String column2, String column3, String column4, String column5, String column6);

        /**
         * Complete route definition as such that emits created rows'
         * 6-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Relation<Tuple6<V1, V2, V3, V4, V5, V6>>> result(Type6<V1, V2, V3, V4, V5, V6> type);

        /**
         * Complete route definition as such that emits created rows'
         * 6-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Relation<Tuple6<V1, V2, V3, V4, V5, V6>>> result(String column1, String column2, String column3, String column4, String column5, String column6, Type6<V1, V2, V3, V4, V5, V6> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param handler the given created rows' 6-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, Block1<? super Relation<Tuple6<V1, V2, V3, V4, V5, V6>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param handler the given created rows' 6-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, Block1<? super Tuple6<V1, V2, V3, V4, V5, V6>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 6-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R result(Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Relation<Tuple6<V1, V2, V3, V4, V5, V6>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 6-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R handle(Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Tuple6<V1, V2, V3, V4, V5, V6>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 6-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Relation<Tuple6<V1, V2, V3, V4, V5, V6>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 6-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 6-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Tuple6<V1, V2, V3, V4, V5, V6>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 7-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @param <V7> the type of the column 7 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Tuple7<V1, V2, V3, V4, V5, V6, V7>> relate7();

        /**
         * Complete route definition as such that emits created rows'
         * 7-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>> result(String column1, String column2, String column3, String column4, String column5, String column6, String column7);

        /**
         * Complete route definition as such that emits created rows'
         * 7-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @param <V7> the type of the column 7 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>> result(Type7<V1, V2, V3, V4, V5, V6, V7> type);

        /**
         * Complete route definition as such that emits created rows'
         * 7-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>> result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, Type7<V1, V2, V3, V4, V5, V6, V7> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param handler the given created rows' 7-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, Block1<? super Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param handler the given created rows' 7-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, String column7, Block1<? super Tuple7<V1, V2, V3, V4, V5, V6, V7>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 7-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R result(Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 7-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R handle(Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Tuple7<V1, V2, V3, V4, V5, V6, V7>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 7-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 7-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 7-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, String column7, Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Tuple7<V1, V2, V3, V4, V5, V6, V7>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits created rows'
         * 8-columns relation result of generated keys.
         *
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @param <V7> the type of the column 7 of the generated keys tuple
         * @param <V8> the type of the column 8 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>> relate8();

        /**
         * Complete route definition as such that emits created rows'
         * 8-columns generated keys relation result by the given column names.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>> result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8);

        /**
         * Complete route definition as such that emits created rows'
         * 8-columns generated keys relation result by the given columns types definition object.
         *
         * @param type the given generated keys columns types definition object
         * @param <V1> the type of the column 1 of the generated keys tuple
         * @param <V2> the type of the column 2 of the generated keys tuple
         * @param <V3> the type of the column 3 of the generated keys tuple
         * @param <V4> the type of the column 4 of the generated keys tuple
         * @param <V5> the type of the column 5 of the generated keys tuple
         * @param <V6> the type of the column 6 of the generated keys tuple
         * @param <V7> the type of the column 7 of the generated keys tuple
         * @param <V8> the type of the column 8 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>> result(Type8<V1, V2, V3, V4, V5, V6, V7, V8> type);

        /**
         * Complete route definition as such that emits created rows'
         * 8-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param type    the given generated keys columns types definition object
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @return emitting relation result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>> result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys relation result by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param handler the given created rows' 8-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8, Block1<? super Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys tuples by the given column name.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param handler the given created rows' 8-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8, Block1<? super Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys relation result by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 8-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R result(Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys tuples by the given columns types definition object.
         *
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 8-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R handle(Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys relation result by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 8-columns generated keys relation result handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R result(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the created rows'
         * 8-columns generated keys tuples by the given column names and types definition object.
         *
         * @param column1 the given generated keys column 1 name
         * @param column2 the given generated keys column 2 name
         * @param column3 the given generated keys column 3 name
         * @param column4 the given generated keys column 4 name
         * @param column5 the given generated keys column 5 name
         * @param column6 the given generated keys column 6 name
         * @param column7 the given generated keys column 7 name
         * @param column8 the given generated keys column 8 name
         * @param type    the given generated keys columns types definition object
         * @param handler the given created rows' 8-columns generated keys tuples handling route
         * @param <V1>    the type of the column 1 of the generated keys tuple
         * @param <V2>    the type of the column 2 of the generated keys tuple
         * @param <V3>    the type of the column 3 of the generated keys tuple
         * @param <V4>    the type of the column 4 of the generated keys tuple
         * @param <V5>    the type of the column 5 of the generated keys tuple
         * @param <V6>    the type of the column 6 of the generated keys tuple
         * @param <V7>    the type of the column 7 of the generated keys tuple
         * @param <V8>    the type of the column 8 of the generated keys tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R handle(String column1, String column2, String column3, String column4, String column5, String column6, String column7, String column8, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>, ? extends Routing<? extends $R>> handler);
    }

    /**
     * RDBMS execution definition object that defines emission of the queried {@link Tuple}s.
     *
     * @param <X> the type of the relation tuple
     * @param <R> the type of the relation
     */
    interface Relating<X extends Tuple, R extends Relation<? extends X>>
            extends Fetching<Relating<X, R>>, Emitting<X> {

        /**
         * Continue route definition in the given handler of the result relation.
         *
         * @param handler the given handler of the result relation
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R result(Block1<? super R, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given handler of the result relation tuples.
         *
         * @param handler the given handler of the result relation tuple
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R handle(Block1<? super X, ? extends Routing<? extends $R>> handler);
    }

    /**
     * RDBMS stored procedure invocation definition object that defines
     * emission of procedure parameters output.
     */
    interface Invoking extends Fetching<Invoking>, Emitting<Output> {


        /**
         * Continue route definition in the specified handler of the output parameters values.
         *
         * @param handler the given output parameters values handler
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R output(Block1<? super Output, ? extends Routing<? extends Flowing<?>>> handler);

        /**
         * Continue route definition in the specified handler of the output parameter value
         * by the given name.
         *
         * @param name    the given output parameter name
         * @param handler the given output parameter handler
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R output(String name, Block1<? super Object, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the specified handler of the output parameter value
         * by the given name and value type definition.
         *
         * @param name    the given output parameter name
         * @param type    the given output parameter value type definition
         * @param handler the given output parameter handler
         * @param <V>     the type of the output parameter value
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R output(String name, Type1<V> type, Block1<? super V, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits
         * output parameter value by the given name.
         *
         * @param name the given output parameter name
         * @param <V>  the type of the output parameter value
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<V> output(String name);

        /**
         * Complete route definition as such that emits
         * output parameter value by the given name and value type definition.
         *
         * @param name the given output parameter name
         * @param type the given output parameter value type definition
         * @param <V>  the type of the output parameter value
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<V> output(String name, Type1<V> type);

        /**
         * Complete route definition as such that emits relation results of the operation.
         *
         * @return emitting results definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<Relation<?>> result();

        /**
         * Continue route definition in the given handler of the relation results of the operation.
         *
         * @param handler the given relation results handler
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R result(Block1<? super Relation<?>, ? extends Routing<? extends $R>> handler);

        /**
         * Complete route definition as such that emits relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        Emitting<Relation<?>> result(int result);

        /**
         * Continue route definition in the given handler of the relation result
         * of the operation by the given result index.
         *
         * @param result  the given result index
         * @param handler the given relation result handler
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R result(int result, Block1<? super Relation<?>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given tuples handler
         * of the relation result of the operation by the given result index.
         *
         * @param result  the given result index
         * @param handler the given relation result tuples handler
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <$R extends Routing<?>> $R handle(int result, Block1<? super Tuple, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 1-column relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V>    the type of the column 1 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Tuple1<V>> relate1(int result);

        /**
         * Complete route definition as such that emits 1-column relation
         * result of the operation by the given result index and column values type definition.
         *
         * @param result the given result index
         * @param type   the given column values type definition
         * @param <V>    the type of the column 1 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V> Emitting<Relation<Tuple1<V>>> result(int result, Type1<V> type);

        /**
         * Continue route definition in the given tuples handler of the 1-column relation result
         * of the operation by the given result index and column values type definition.
         *
         * @param result  the given result index
         * @param type    the given column values type definition
         * @param handler the given relation result handler
         * @param <V>     the type of the column 1 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R result(int result, Type1<V> type, Block1<? super Relation<Tuple1<V>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 1-column tuples handler
         * of the relation result of the operation by the given result index and column values type definition.
         *
         * @param result  the given result index
         * @param type    the given column values type definition
         * @param handler the given relation result tuples handler
         * @param <V>     the type of the column 1 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V, $R extends Routing<?>> $R handle(int result, Type1<V> type, Block1<? super Tuple1<V>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 2-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Tuple2<V1, V2>> relate2(int result);

        /**
         * Complete route definition as such that emits 2-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2> Emitting<Relation<Tuple2<V1, V2>>> result(int result, Type2<V1, V2> type);

        /**
         * Continue route definition in the given handler of the 2-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R result(int result, Type2<V1, V2> type, Block1<? super Relation<Tuple2<V1, V2>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 2-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, $R extends Routing<?>> $R handle(int result, Type2<V1, V2> type, Block1<? super Tuple2<V1, V2>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 3-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Tuple3<V1, V2, V3>> relate3(int result);

        /**
         * Complete route definition as such that emits 3-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3> Emitting<Relation<Tuple3<V1, V2, V3>>> result(int result, Type3<V1, V2, V3> type);

        /**
         * Continue route definition in the given handler of the 3-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R result(int result, Type3<V1, V2, V3> type, Block1<? super Relation<Tuple3<V1, V2, V3>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 3-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, $R extends Routing<?>> $R handle(int result, Type3<V1, V2, V3> type, Block1<? super Tuple3<V1, V2, V3>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 4-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Tuple4<V1, V2, V3, V4>> relate4(int result);

        /**
         * Complete route definition as such that emits 4-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4> Emitting<Relation<Tuple4<V1, V2, V3, V4>>> result(int result, Type4<V1, V2, V3, V4> type);

        /**
         * Continue route definition in the given handler of the 4-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R result(int result, Type4<V1, V2, V3, V4> type, Block1<? super Relation<Tuple4<V1, V2, V3, V4>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 4-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, $R extends Routing<?>> $R handle(int result, Type4<V1, V2, V3, V4> type, Block1<? super Tuple4<V1, V2, V3, V4>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 5-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Tuple5<V1, V2, V3, V4, V5>> relate5(int result);

        /**
         * Complete route definition as such that emits 5-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5> Emitting<Relation<Tuple5<V1, V2, V3, V4, V5>>> result(int result, Type5<V1, V2, V3, V4, V5> type);

        /**
         * Continue route definition in the given handler of the 5-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R result(int result, Type5<V1, V2, V3, V4, V5> type, Block1<? super Relation<Tuple5<V1, V2, V3, V4, V5>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 5-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, $R extends Routing<?>> $R handle(int result, Type5<V1, V2, V3, V4, V5> type, Block1<? super Tuple5<V1, V2, V3, V4, V5>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 6-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Tuple6<V1, V2, V3, V4, V5, V6>> relate6(int result);

        /**
         * Complete route definition as such that emits 6-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6> Emitting<Relation<Tuple6<V1, V2, V3, V4, V5, V6>>> result(int result, Type6<V1, V2, V3, V4, V5, V6> type);

        /**
         * Continue route definition in the given handler of the 6-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R result(int result, Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Relation<Tuple6<V1, V2, V3, V4, V5, V6>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 6-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, $R extends Routing<?>> $R handle(int result, Type6<V1, V2, V3, V4, V5, V6> type, Block1<? super Tuple6<V1, V2, V3, V4, V5, V6>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 7-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @param <V7>   the type of the column 7 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Tuple7<V1, V2, V3, V4, V5, V6, V7>> relate7(int result);

        /**
         * Complete route definition as such that emits 7-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @param <V7>   the type of the column 7 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7> Emitting<Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>> result(int result, Type7<V1, V2, V3, V4, V5, V6, V7> type);

        /**
         * Continue route definition in the given handler of the 7-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <V7>    the type of the column 7 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R result(int result, Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Relation<Tuple7<V1, V2, V3, V4, V5, V6, V7>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 7-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <V7>    the type of the column 7 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, $R extends Routing<?>> $R handle(int result, Type7<V1, V2, V3, V4, V5, V6, V7> type, Block1<? super Tuple7<V1, V2, V3, V4, V5, V6, V7>, ? extends Routing<? extends $R>> handler);


        /**
         * Complete route definition as such that emits 8-columns relation
         * result of the operation by the given result index.
         *
         * @param result the given result index
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @param <V7>   the type of the column 7 values
         * @param <V8>   the type of the column 8 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>> relate8(int result);

        /**
         * Complete route definition as such that emits 8-columns relation
         * result of the operation by the given result index and column values types definition.
         *
         * @param result the given result index
         * @param type   the given column values types definition
         * @param <V1>   the type of the column 1 values
         * @param <V2>   the type of the column 2 values
         * @param <V3>   the type of the column 3 values
         * @param <V4>   the type of the column 4 values
         * @param <V5>   the type of the column 5 values
         * @param <V6>   the type of the column 6 values
         * @param <V7>   the type of the column 7 values
         * @param <V8>   the type of the column 8 values
         * @return emitting result definition object
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8> Emitting<Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>> result(int result, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type);

        /**
         * Continue route definition in the given handler of the 8-columns relation result
         * of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <V7>    the type of the column 7 values
         * @param <V8>    the type of the column 8 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R result(int result, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Relation<Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>>, ? extends Routing<? extends $R>> handler);

        /**
         * Continue route definition in the given 8-columns tuples handler
         * of the relation result of the operation by the given result index and column values types definition.
         *
         * @param result  the given result index
         * @param type    the given column values types definition
         * @param handler the given relation result tuples handler
         * @param <V1>    the type of the column 1 values
         * @param <V2>    the type of the column 2 values
         * @param <V3>    the type of the column 3 values
         * @param <V4>    the type of the column 4 values
         * @param <V5>    the type of the column 5 values
         * @param <V6>    the type of the column 6 values
         * @param <V7>    the type of the column 7 values
         * @param <V8>    the type of the column 8 values
         * @param <$R>    the type of the route definition result
         * @return handling route definition result
         * @throws RuntimeException an exception in case of route definition error
         */
        <V1, V2, V3, V4, V5, V6, V7, V8, $R extends Routing<?>> $R handle(int result, Type8<V1, V2, V3, V4, V5, V6, V7, V8> type, Block1<? super Tuple8<V1, V2, V3, V4, V5, V6, V7, V8>, ? extends Routing<? extends $R>> handler);
    }
}
